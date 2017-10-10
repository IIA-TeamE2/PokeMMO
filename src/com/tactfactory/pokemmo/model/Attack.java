package com.tactfactory.pokemmo.model;

/**
 * Attack of Character.
 */
public class Attack {

    /** Name of Damage */
    protected String name = "";

    /** Point ?????? */
    protected int pp = 10;

    /** Damage of Attack */
    protected int damage = 0;

    /** Element type of attack. */
    protected Element element;

    public Attack(String name, Element element) {
        this.name = name;
        this.element = element;
    }

    /**
     * @return the pp
     */
    public int getPp() {
        return pp;
    }

    /**
     * @param pp the pp to set
     */
    public void setPp(int pp) {
        this.pp = pp;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
