package com.tactfactory.pokemmo.net.server.entity;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ClientConnection {
	private ClientConnection self = this;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean connected = true;
	private HashMap<String, Object> values = new HashMap<String, Object>();
	private HashMap<Short, Class<? extends PacketProcessor>> processors = new HashMap<Short, Class<? extends PacketProcessor>>();
	
	public ClientConnection(Socket socket) {
		this.socket = socket;
		try {
			this.input = new ObjectInputStream(socket.getInputStream());
			this.output = new ObjectOutputStream(socket.getOutputStream());
		}
		catch(Exception er) {
			System.out.println("Error on getting input and output stream");
			return;
		}
		
		readPackets();
	}
	public Object getValue(String name) {
		if(values.containsKey(name))
			return values.get(name);
		return null;
	}
	public void setValue(String name, Object value) {
		if(values.containsKey(name)) {
			values.remove(name);
		}
		values.put(name, value);
	}
	public void send(short type, byte[] data) {
		try {
			this.output.writeShort(type);
			this.output.writeShort(data.length);
			this.output.write(data);
			this.output.flush();
		}catch(Exception err) {
			System.out.println("Error on sending data");
			close();
		}
	}
	public void close() {
		try {
			try {this.input.close();}catch(Exception err) {}
			try {this.output.close();}catch(Exception err) {}
			
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
			socket = null;
			this.connected = false;
		}
		catch(Exception err) {
			System.out.println("Error on closing Socket");
		}
	}
	private void readPackets() {
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(connected) {
					try {
						while(input.available() == 0) {
							Thread.sleep(250);
						}
					}
					catch(Exception err) {
						System.out.println("Socket Error on reading data");
						close();
						return;
					}
					
					try {
						short type = input.readShort();
						short size = input.readShort();
						byte[] data = new byte[size];
						input.read(data);
						
						if(processors.containsKey(type)) {
							PacketProcessor process = processors.get(type).newInstance();
							
							if(process != null) {
								process.setConnection(self);
								process.setInput(new DataInputStream(new ByteArrayInputStream(data)));
								process.execute();
							}
							else System.out.println("Error on executing process");
						}
						else System.out.println("Error :: packet not found");
					}
					catch(Exception err) {
						System.out.println("Error on reading Packet protocole");
					}
				}
			}
		});
		th.start();
	}
}
