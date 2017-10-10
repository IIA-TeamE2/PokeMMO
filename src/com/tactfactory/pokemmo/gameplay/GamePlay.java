/**
 * 
 */
package com.tactfactory.pokemmo.gameplay;

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
			int attack = attack(attaquant);
			bool hit = checkHit();
			
			defenseDown(hit, attack, defenseur);

			Alive = isAlive(defenseur);
			
			turn();
			
		}
	}
	
	private void turn() {
		this.defenseur = this.defenseur == perso1 ? perso2 : perso1; 
	}
}
