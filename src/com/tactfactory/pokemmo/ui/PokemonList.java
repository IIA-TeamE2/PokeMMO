package com.tactfactory.pokemmo.ui;

import java.util.HashMap;
import java.util.Scanner;

public class PokemonList {
	
	/**
	 * Show the list of the 151 pokemon who can be played and ask the User's choice
	 * @return The pokemon in a String format
	 */
	public String chooseList(){
		
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		for (int i = 1; i < 152; i++) {
			System.out.println("Nom du pokemon :" + list.keySet() + " Défense : " + list.values());
		} 
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		return choice;
		
	}
	
	
}
