/**
 * 
 */
package com.tactfactory.pokemmo.gameplay;

import java.util.Random;

import com.tactfactory.pokemmo.model.User;

/**
 * @author ALEPAG1
 *
 */
public class GamePlay {
	
	User user;
		
	Character pokemon;
	
	public GamePlay() {}
	
	public void run() {
		//fonction qui demande le pseudo du user
		//Recup�re une string
		
		this.user = new User(userName);
		
		//Fonction qui demande l'�l�ment du pok�mon � l'user
		//R�cup�re l'�l�ment
		
		this.pokemon = new Character("Nom du Pok�mon", element);
	}

}
