package com.tactfactory.pokemmo.gameplay.net.entity;

import java.io.DataInputStream;

import com.tactfactory.pokemmo.gameplay.net.Client;

public abstract class PacketProcessor {
	protected DataInputStream input;
	protected Client connection;
	
	public Client getConnection() {
		return this.connection;
	}
	public void setConnection(Client con) {
		this.connection = con;
	}
	public void setInput(DataInputStream input) {
		this.input = input;
	}
	public abstract void execute();
}
