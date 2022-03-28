package units;

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
     * @param opponent the opponent to attack
     */
    public void attack (Unit opponent) {
        int newHealth = opponent.getHealth() - (attack + getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.setHealth(newHealth);
        //TODO: check for healing
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
    public void setHealth(int health) {
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
     * @return the attack bonus of the unit
     */
    public abstract int getAttackBonus();

    /**
     * Gets the unit's resist bonus.
     * @return the resist bonus of the unit
     */
    public abstract int getResistBonus();

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
}