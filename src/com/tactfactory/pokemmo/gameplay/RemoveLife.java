package com.tactfactory.pokemmo.gameplay;



public class RemoveLife {
	
	/**
	 * Function removing defense from a defenseur 
	 * with the attack of the other player
	 * 
	 * 
	 * @param hit
	 * @param attack
	 * @param defenseur
	 */
	public static void defenseDown(boolean hit, int attack, Perso defenseur) {
	
	defenseur.defense = hit ? defenseur.defense - attack : defenseur.defense; 
		 
		
	}
	
}
