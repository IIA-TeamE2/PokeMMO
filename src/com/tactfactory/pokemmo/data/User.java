package com.tactfactory.pokemmo.data;

/**
 * 
 * @author scosqu
 * Class User with max 2 user in session
 * 1 user = 1 Perso
 */
public class User {
	
	protected String pseudo;

	// Getter Pseudo User
	public String getPseudo() {
		return pseudo;
	}

	//Setter Pseudo User
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}

