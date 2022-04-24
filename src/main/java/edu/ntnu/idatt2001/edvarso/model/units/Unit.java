package edu.ntnu.idatt2001.edvarso.model.units;

import java.util.Objects;

/**
 * The abstract superclass Unit.
 * All specialized unit classes inherit from this superclass.
 */
public abstract class Unit {
    private final String name;
    private int health;
    private final int attack;
    private final int armor;
    private int timesAttacked = 0;
    private int timesDefended = 0;

    /**
     * Constructor for the Unit class
     * @param name a short, descriptive name of the unit. For example "Swordsman" or "Archer"
     * @param health the unit's health. Must be larger than or equal to 0
     * @param attack an attack value representing the unit's weapon
     * @param armor a defense value that protects during an attack
     */
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        if (name.isEmpty()) throw new IllegalArgumentException("The unit must have a name.");
        if (health <= 0) throw new IllegalArgumentException("The health value must be larger than 0.");
        if (attack <= 0) throw new IllegalArgumentException("The attack value must be larger than 0.");
        if (armor < 0) throw new IllegalArgumentException("The armor value can't be negative.");

        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Performs an attack on an opponent.
     * A new health value is calculated for the defending unit
     *
     * @param opponent the opponent to attack
     */
    public void attack (Unit opponent, String terrain) {
        int newHealth = opponent.getHealth() - (attack + getAttackBonus(terrain)) + (opponent.getArmor() + opponent.getResistBonus(terrain));

        if (newHealth < 0) {
            opponent.setHealth(0);
        } else if (newHealth < opponent.getHealth()){
            opponent.setHealth(newHealth);
        }

        this.timesAttacked++;
        opponent.timesDefended++;
    }

    /**
     * Gets the unit's name.
     * @return the name of the unit
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unit's current health.
     * @return the health of the unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the unit's attack value.
     * @return the attack value of the unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the units armor value.
     * @return the armor value of the unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets the unit's health value.
     * @param health the new health value for the unit
     */
    public void setHealth(int health) throws IllegalArgumentException {
        if (health < 0) throw new IllegalArgumentException("The health value cannot be less than 0");

        this.health = health;
    }

    /**
     * Formats the unit with a toString method.
     * @return a short description of the unit and its values
     */
    @Override
    public String toString() {
        return "units.Unit: " +
                "Name: " + name +
                ", health: " + health +
                ", attack: " + attack +
                ", armor: " + armor;
    }

    /**
     * Gets the unit's attack bonus.
     * @param terrain the terrain where the unit is attacking
     * @return the attack bonus of the unit
     */
    public abstract int getAttackBonus(String terrain);

    /**
     * Gets the unit's resist bonus.
     * @param terrain the terrain where the unit is defending
     * @return the resist bonus of the unit
     */
    public abstract int getResistBonus(String terrain);

    /**
     * Gets the number of times the unit has attacked another unit.
     * @return the number of times attacked
     */
    public int getTimesAttacked() {
        return timesAttacked;
    }

    /**
     * Gets the number of times the unit has defended an attack.
     * @return the number of times defended
     */
    public int getTimesDefended() {
        return timesDefended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return health == unit.health && attack == unit.attack && armor == unit.armor && Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, attack, armor);
    }
}