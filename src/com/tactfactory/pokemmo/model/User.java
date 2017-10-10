package com.tactfactory.pokemmo.model;

/**
 * User of the game.
 */
public class User {

    /** Pseudo of user. */
    protected String pseudo = "";

    protected Character character;

    public User(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * @param character the character to set
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

}
