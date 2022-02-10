/**
 * The abstract class Unit
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * Constructor for the Unit class
     * @param name a short, descriptive name. For example "Swordsman" or "Archer".
     * @param health the unit's health. Must be larger than or equal to 0.
     * @param attack an attack value representing the unit's weapon.
     * @param armor a defense value that protects during an attack.
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Performs an attack on an opponent.
     * @param opponent the opponent to attack.
     */
    public void attack (Unit opponent) {
        // Må vi bruke this her?
        int newHealth = opponent.getHealth() - (this.getAttack() - this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.setHealth(newHealth);
    }

    /**
     * Gets the unit's name.
     * @return returns the name in a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unit's current health.
     * @return returns the health as a number.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the unit's attack value.
     * @return returns the attack value.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the units armor value.
     * @return returns the armor value.
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets the unit's health value.
     * @param health takes in the new health value as a parameter.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Formats the unit with a toString method.
     * @return returns a short description of the unit and its values.
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }

    /**
     * Gets the unit's attack bonus.
     * @return returns the attack bonus.
     */
    public abstract int getAttackBonus();

    /**
     * Gets the unit's resist bonus.
     * @return returns the resist bonus.
     */
    public abstract int getResistBonus();
}
