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
		//Recupère une string
		
		this.user = new User(userName);
		
		//Fonction qui demande l'élément du pokémon à l'user
		//Récupère l'élément
		
		this.pokemon = new Character("Nom du Pokémon", element);
	}

}
