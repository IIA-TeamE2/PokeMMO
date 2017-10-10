package com.tactfactory.pokemmo.net.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.tactfactory.pokemmo.net.server.entity.ClientConnection;

public class ServerListener {
	private ServerSocket server;
	private ArrayList<ClientConnection> connection = new ArrayList<ClientConnection>();
	
	public ServerListener(int port) {
		try {
			server = new ServerSocket(port);
			Thread th = new Thread(run);
			th.isDaemon();
			th.start();
		}
		catch(Exception er) {
			System.out.println("Error on listening serverSocket on port " + port);
		}
	}
	private Runnable run = new Runnable() {
		@Override
		public void run() {
			while(true) {
				try {
					Socket socket = server.accept();
					connection.add(new ClientConnection(socket));
				}
				catch(Exception err) {
					System.out.println("Error on accepting socket");
				}
			}
		}
	};
}
