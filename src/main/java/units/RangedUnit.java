package units;

/**
 * The specialized unit class RangedUnit, which inherits from the superclass Unit.
 */
public class RangedUnit extends Unit{

    /**
     * Constructor for the RangedUnit class, which inputs all Unit attributes as parameters.
     * @param name the name of the ranged unit
     * @param health the starting health of the ranged unit
     * @param attack the attack value of the ranged unit
     * @param armor the armor value of the ranged unit
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the RangedUnit class, with only "name" and "health" as input parameters.
     * The other attributes for the superclass Unit are fixed values.
     * @param name the name of the ranged unit
     * @param health the starting health of the ranged unit
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    /**
     * Gets the ranged unit's attack bonus.
     * @param terrain the terrain where the attack happens
     * @return returns the calculated attack bonus, which is higher if the terrain is "HILL",
     * and lower if the terrain is "FOREST"
     */
    @Override
    public int getAttackBonus(String terrain) {
        if (terrain.equals("HILL")) {
            return 6;
        } else if (terrain.equals("FOREST")) {
            return 1;
        } else {
            return 3;
        }
    }

    /**
     * Gets the ranged unit's resist bonus.
     * @param terrain the terrain where the defense happens
     * @return the calculated resist bonus, based on the number of times defended an attack so far
     */
    @Override
    public int getResistBonus(String terrain) {
        int resistBonus = 2;

        if (getTimesDefended() == 0) {
            resistBonus = 6;
        } else if (getTimesDefended() == 1) {
            resistBonus = 4;
        }

        return resistBonus;
    }

}
