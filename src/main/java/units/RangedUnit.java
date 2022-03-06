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
     * @return returns a fixed attack bonus
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * Gets the ranged unit's resist bonus.
     * @return the calculated resist bonus, based on the number of times defended an attack so far
     */
    @Override
    public int getResistBonus() {
        int resistBonus = 2;

        if (getTimesDefended() == 0) {
            resistBonus = 6;
        } else if (getTimesDefended() == 1) {
            resistBonus = 4;
        }

        return resistBonus;
    }

}
