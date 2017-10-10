/**
 * 
 */
package com.tactfactory.pokemmo.gameplay;

import java.util.Random;

/**
 * @author ALEPAG1
 *
 */
public class GamePlay {
	
	Session session = new Session();
	
	User user1 = new User(session);
	User user2 = new User(session);
	
	Perso perso1 = new Perso(user1);
	Perso perso2 = new Perso(user2);
	
	Perso defenseur = perso2;
	
	public static void Gameplay() {
		
		Boolean Alive = true;
		
		while(Alive()) {
			int attack = attack();
			bool hit = checkHit();
			
			defenseDown(hit, attack, defenseur);

			Alive = isAlive(defenseur);
			
			turn();
			
		}
	}
	
	private int attack() {
		Random r = new Random();
		return r.nextInt(10);
	}
	
	private boolean checkHit() {
		Random r = new Random();
		random = r.nextInt(10);
		
		return random >= 5;
	}
	
	private void defenseDown(boolean hit, int attack, Perso defenseur) {
		defenseur.defense = hit ? defenseur.defense - attack : defenseur.defense;
	}
	
	public Boolean isAlive(Perso defenseur){
		return defenseur.defense > 0;
	}
	
	private void turn() {
		this.defenseur = this.defenseur == perso1 ? perso2 : perso1; 
	}
}
