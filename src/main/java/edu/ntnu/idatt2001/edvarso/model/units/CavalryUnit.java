package edu.ntnu.idatt2001.edvarso.model.units;

import edu.ntnu.idatt2001.edvarso.model.battle.Terrain;

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
     * @param terrain the terrain where the attack happens
     * @return the calculated attack bonus, based on the numbers of attacks performed so far,
     * and whether the terrain is "PLAINS"
     */
    @Override
    public int getAttackBonus(Terrain terrain) {
        int attackBonus = 2;

        if (terrain.equals(Terrain.PLAINS)) {
            attackBonus += 2;
        }

        if (getTimesAttacked() == 0) {
            attackBonus += 4;
        }

        return attackBonus;
    }

    /**
     * Gets the cavalry unit's resist bonus.
     * @param terrain the terrain where the defense happens
     * @return the resist bonus, which is 0 if the terrain is "FOREST"
     */
    @Override
    public int getResistBonus(Terrain terrain) {
        if (terrain.equals(Terrain.FOREST)) {
            return 0;
        } else {
            return 1;
        }
    }

}
