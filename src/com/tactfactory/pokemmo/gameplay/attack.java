package com.tactfactory.pokemmo.gameplay;

import java.util.Random;

public class attack {

	public int dammage;
	public boolean isdodge;
	
	public void atk() {
		Random r = new Random();
		dammage = 0 + r.nextInt(10 - 0 );
		
		if (dammage >= 3) {
			isdodge = false;
		}else {
			isdodge = false;
		}
	}
}
