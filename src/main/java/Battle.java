import units.Unit;

import java.util.Random;

/**
 * The class Battle, which simulates a battle between two armies.
 */
public class Battle {
    Army armyOne;
    Army armyTwo;

    /**
     * The constructor for the Battle class.
     * @param armyOne the first of the two battling armies
     * @param armyTwo the second of the two battling armies
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
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

            int i = rand.nextInt(armyOne.getAllUnits().size()+armyTwo.getAllUnits().size());

            if (i < armyOne.getAllUnits().size()) {
                attacker = armyOne.getRandom();
                defender = armyTwo.getRandom();
            } else {
                attacker = armyTwo.getRandom();
                defender = armyOne.getRandom();
            }

            attacker.attack(defender);

            if (defender.getHealth() <= 0) {
                if (armyOne.getAllUnits().contains(defender)) armyOne.remove(defender);
                else armyTwo.remove(defender);
            }


        }

        if (armyOne.hasUnits()) {
            return armyOne;
        } else {
            return armyTwo;
        }

    }

    @Override
    public String toString() {
        return "Battle: " + armyOne + " vs " + armyTwo;
    }
}
