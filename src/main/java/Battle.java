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

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            Unit armyOneAttacker = armyOne.getRandom();
            Unit armyTwoDefender = armyTwo.getRandom();

            armyOneAttacker.attack(armyTwoDefender);

            if (armyTwoDefender.getHealth() <= 0) {
                armyTwo.remove(armyTwoDefender);
            }

            if (armyTwo.hasUnits()) {
                Unit armyTwoAttacker = armyTwo.getRandom();
                Unit armyOneDefender = armyOne.getRandom();

                armyTwoAttacker.attack(armyOneDefender);

                if (armyOneDefender.getHealth() <= 0) {
                    armyOne.remove(armyOneDefender);
                }
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
