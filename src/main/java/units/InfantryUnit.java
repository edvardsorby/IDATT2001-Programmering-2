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
     * @param terrain the terrain where the attack happens
     * @return returns an attack bonus, which is higher if the terrain is "FOREST"
     */
    @Override
    public int getAttackBonus(String terrain) {
        if (terrain.equals("FOREST")) {
            return 4;
        } else {
            return 2;
        }
    }

    /**
     * Gets the infantry unit's resist bonus.
     * @param terrain the terrain where the defense happens
     * @return returns a resist bonus, which is higher if the terrain is "FOREST"
     */
    @Override
    public int getResistBonus(String terrain) {
        if (terrain.equals("FOREST")) {
            return 2;
        } else {
            return 1;
        }
    }
}
