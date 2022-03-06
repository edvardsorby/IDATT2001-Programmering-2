package units;

/**
 * The specialized unit class InfantryUnit, which inherits from the superclass Unit.
 */
public class InfantryUnit extends Unit{
    /**
     * Constructor for the InfantryUnit class, which inputs all Unit attributes as parameters.
     * @param name the name of the infantry unit
     * @param health the starting health of the infantry unit
     * @param attack the attack value of the infantry unit
     * @param armor the armor value of the infantry unit
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the InfantryUnit class, with only "name" and "health" as input parameters.
     * The other attributes for the superclass Unit are fixed values.
     * @param name the name of the infantry unit
     * @param health the starting health of the infantry unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }

    /**
     * Gets the infantry unit's attack bonus.
     * @return returns a fixed attack bonus
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * Gets the infantry unit's resist bonus.
     * @return returns a fixed resist bonus
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
