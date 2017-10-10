package com.tactfactory.pokemmo.ui;

import java.util.Scanner;

/**
 * It's only print the connection's message.
 * @author Balidas Benjamin
 *
 */
public class Connection {
	
	/**
	 * Ask the IP of the serv, and return the IP asked.
	 * @return	An IP in a String format.
	 */
	public String askIP() {
		System.out.println("Quel est l'IP du serveur ?");
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();
		return ip;
	}
	
	/**
	 * Say good when the connection is established.
	 */
	public void etablished() {
		System.out.println("Connexion établie.");
	}
	
	/**
	 * Say bad when the connection is established.
	 */
	public void failed() {
		System.out.println("Connexion impossible.");
	}
	
	/**
	 * Ask the pseudo of the serv, and return the pseudo asked.
	 * @return	A pseudo in a String format.
	 */
	public String getPseudo() {
		System.out.println("Quel est votre pseudo ?");
		Scanner sc = new Scanner(System.in);
		String pseudo = sc.nextLine();
		return pseudo;
	}
	
	/**
	 * Say lost when the connection is established.
	 */
	public void lost() {
		System.out.println("Connexion perdue.");
	}
	
}
