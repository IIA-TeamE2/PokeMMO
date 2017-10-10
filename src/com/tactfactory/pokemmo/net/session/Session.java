package com.tactfactory.pokemmo.net.session;

import com.tactfactory.pokemmo.net.server.entity.ClientConnection;

public class Session {

	private Fighter user1;
	private Fighter user2;
	
	public Session(ClientConnection user1, ClientConnection user2) {
		this.user1 = new Fighter(user1, user1.getValue("pseudo").toString());
		this.user2 = new Fighter(user2, user2.getValue("pseudo").toString());
		
	}
	
}


