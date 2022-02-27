/**
 * The specialized unit class CavalryUnit, which inherits from the superclass Unit.
 */
public class CavalryUnit extends Unit{

    /**
     * Constructor for the CavalryUnit class, which inputs all Unit attributes as parameters.
     * @param name the name of the cavalry unit
     * @param health the starting health of the cavalry unit
     * @param attack the attack value of the cavalry unit
     * @param armor the armor value of the cavalry unit
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for the CavalryUnit class, with only "name" and "health" as input parameters.
     * The other attributes for the superclass Unit are fixed values.
     * @param name the name of the cavalry unit
     * @param health the starting health of the cavalry unit
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    /**
     * Gets the cavalry unit's attack bonus.
     * @return the calculated attack bonus, based on the numbers of attacks performed so far
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 2;

        if (getTimesAttacked() == 0) {
            attackBonus = 4 + 2;
        }

        return attackBonus;
    }

    /**
     * Gets the cavalry unit's resist bonus.
     * @return a fixed resist bonus
     */
    @Override
    public int getResistBonus() {
        return 1;
    }

}
