package com.tactfactory.pokemmo.gameplay.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.tactfactory.pokemmo.ui.Connection;

public class Client {
	private static Client self;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean connected = false;
	private String ip;
	private int port;
	private Connection connectionDisplay = new Connection();
	
	public Client(String ip, int host) {
		this.ip = ip;
		this.port = host;
		self = this;
		connectToServer(ip, host);
		readPackets();
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
						System.out.println("Error on reading Packets");
						close();
					}
					try {
						short type = input.readShort();
						short size = input.readShort();
						byte[] data = new byte[size];
						input.read(data);
					}
					catch(Exception err) {
						System.out.println("Error on reading packet");
						close();
					}
				}
			}
		});
		th.start();
	}
	public boolean isConnected() {
		return connected && socket != null && socket.isConnected();
	}
	public void send(short type, byte[] data) {
		try {
			this.output.writeShort(type);
			this.output.writeShort(data.length);
			this.output.write(data);
		}
		catch(Exception err) {
			close();
		}
	}
	public void close() {
		try {
			//connectionDisplay.connectionLost();
			if(socket != null) {
				socket.close();
			}
			socket = null;
			connectToServer(ip, port);
		}
		catch(Exception err) {
			
		}
	}
	public void connectToServer(String ip, int port) {
		while(socket == null || !socket.isConnected()) {
			try {
				socket = new Socket(ip, port);
				this.input = new ObjectInputStream(socket.getInputStream());
				this.output = new ObjectOutputStream(socket.getOutputStream());
			}
			catch(Exception err) {
				try{
					connectionDisplay.failed();
					Thread.sleep(5000);
				}
				catch(Exception er) {}
			}
		}
	}
	
	public static Client getInstance() {
		return self;
	}
}
