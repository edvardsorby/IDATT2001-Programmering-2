package edu.ntnu.idatt2001.edvarso.model.battle;

import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.units.Unit;

import java.util.Random;

/**
 * The class Battle, which simulates a battle between two armies.
 */
public class Battle {
    private final Army armyOne;
    private final Army armyTwo;
    private final Terrain terrain;

    /**
     * The constructor for the model.battle.Battle class.
     * @param armyOne the first of the two battling armies
     * @param armyTwo the second of the two battling armies
     * @param terrain the terrain where the battle takes place.
     *                Must be either "HILL", "PLAINS" or "FOREST".
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) {
        if (!(terrain.equals(Terrain.HILL) ||
                terrain.equals(Terrain.PLAINS) ||
                terrain.equals(Terrain.FOREST))) {
            throw new IllegalArgumentException("The terrain must be either \"HILL\", \"PLAINS\" or \"FOREST\"");
        }
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        this.terrain = terrain;
    }

    /**
     * Runs the simulation itself.
     * @return the army that successfully defeats all units in the opponent's army
     */
    public Army simulate() {
        Random rand = new Random();

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            Unit attacker;
            Unit defender;

            int i = rand.nextInt(armyOne.getAllUnits().size() + armyTwo.getAllUnits().size());

            if (i < armyOne.getAllUnits().size()) {
                attacker = armyOne.getRandom();
                defender = armyTwo.getRandom();
            } else {
                attacker = armyTwo.getRandom();
                defender = armyOne.getRandom();
            }

            attacker.attack(defender, terrain);

            if (defender.getHealth() == 0) {
                if (armyOne.getAllUnits().contains(defender)) armyOne.remove(defender);
                else armyTwo.remove(defender);
            }


        }

        if (armyOne.hasUnits()) return armyOne;
        else return armyTwo;

    }

    @Override
    public String toString() {
        return "Battle: " + armyOne + " vs " + armyTwo;
    }
}