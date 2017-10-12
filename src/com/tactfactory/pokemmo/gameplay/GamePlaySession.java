/**
 * 
 */
package com.tactfactory.pokemmo.gameplay;

import java.util.Random;

import com.tactfactory.pokemmo.model.Attack;

/**
 * @author User
 *
 */
public class GamePlaySession {
	
	Session session;
	
	User defenseur;
	User attaquant;
	
	boolean isAlive = true;
	
	public GamePlaySession(Session session) {
		this.session = session;
		this.defenseur = this.session.userGuest;
		this.attaquant = this.session.userOwner;
	}
	
	public void run() {
		
		while(this.isAlive) {

			//Fonction qui demande à l'utilisateur quelle attaque utilisée
			//Récupère une string que l'on transforme en Attack (attack)
			
			if(this.attaquant.attack.getPp() > 0) {
				attack(attack); //attack est l'attaque lancé par l'attaquant
				
				this.isAlive = checkIsLife(this.defenseur);
				
				changePosition();
			}
			else {
				//Envoyé chier l'user pour qu'il choississe autre chose
			}
		}
	}
	
	private void attack(Attack attack) {
		//Boolean pour savoir si l'attaque touche ou pas
		boolean isHit = isHit();
		
		//Donne les bons dégâts de l'attaque
		attack.setDamage(generateDamage());
		
		//Reduce Defenser Life
		this.defenseur.character.setLifeCount(
				this.defenseur.character.getLifeCount() - attack.getDamage()
				);
		
		//Decrease PP of character attack by 1
		this.attaquant.character.attack.setPp(this.attaquant.character.attack.getPp() - 1);
	}
	
	private boolean isHit() {
		Random r = new Random();
		int random = r.nextInt(10);
		
		return random >= 5;
	}
	
	private int generateDamage() {
		Random r = new Random();
		return r.nextInt(10);
	}
	
	private boolean checkIsLife(User defenseur) {
		return defenseur.character.getLife() > 0;
	}
	
	private void changePosition() {
		this.defenseur = this.defenseur == this.session.userOwner ? this.session.userGuest : this.session.useOwner;
		this.attaquant = this.attaquant == this.session.userOwner ? this.session.userGuest : this.session.useOwner;
	}

}
