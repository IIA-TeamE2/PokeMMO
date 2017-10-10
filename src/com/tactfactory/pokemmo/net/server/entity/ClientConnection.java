package com.tactfactory.pokemmo.net.server.entity;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection {
	private Socket socket;
	private String pseudo;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean connected = true;
	
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
	public void send() {
		
	}
	public void close() {
		try {
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
