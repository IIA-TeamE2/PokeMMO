package com.tactfactory.pokemmo.net.session;

import com.tactfactory.pokemmo.net.server.entity.ClientConnection;

public class Fighter {

	private ClientConnection connection;
	private boolean isDead;
	private String pseudo;
	
	public Fighter(ClientConnection connection, String pseudo) {
		this.setConnection(connection);
		this.setPseudo(pseudo);
		this.setDead(false);
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public ClientConnection getConnection() {
		return connection;
	}

	public void setConnection(ClientConnection connection) {
		this.connection = connection;
	}
	
	
	
}
