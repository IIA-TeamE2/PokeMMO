package com.tactfactory.pokemmo.net.server.entity;

import java.io.DataInputStream;

public abstract class PacketProcessor {
	protected DataInputStream input;
	protected ClientConnection connection;
	
	public ClientConnection getConnection() {
		return this.connection;
	}
	public void setConnection(ClientConnection con) {
		this.connection = con;
	}
	public void setInput(DataInputStream input) {
		this.input = input;
	}
	public abstract void execute();
}
