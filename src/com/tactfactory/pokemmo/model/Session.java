package com.tactfactory.pokemmo.model;

import java.util.Date;

/**
 * Session party. Use for only one game/party.
 * Need to recreate it if not exist..
 */
public class Session {

    /** Session create at. */
    protected Date date = new Date();

    /** Name of the session */
    protected String name = "";

    /** User owner of the session */
    protected User userOwner = null;

    /** User guest of the session */
    protected User userGuest = null;

    /**
     * Constructor.
     * @param owner User of the session.
     */
    public Session(User owner) {
        this.userOwner = owner;
    }


    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the userGuest
     */
    public User getUserGuest() {
        return userGuest;
    }


    /**
     * @param userGuest the userGuest to set
     */
    public void setUserGuest(User userGuest) {
        this.userGuest = userGuest;
    }


    /**
     * @return the userOwner
     */
    public User getUserOwner() {
        return userOwner;
    }
}
