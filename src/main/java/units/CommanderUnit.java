package units;

/**
 * The specialized unit class CommanderUnit, which inherits from the class units.CavalryUnit.
 */
public class CommanderUnit extends CavalryUnit{

    /**
     * Constructor for the CommanderUnit class, which inputs all Unit attributes as parameters.
     * @param name the name of the commander unit
     * @param health the starting health of the commander unit
     * @param attack the attack value of the commander unit
     * @param armor the armor value of the commander unit
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the CommanderUnit class, with only "name" and "health" as input parameters.
     * The other attributes for the superclass Unit are fixed values.
     * @param name the name of the commander unit
     * @param health the starting health of the commander unit
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }
}
