package edu.ntnu.idatt2001.edvarso.model.factory;

import edu.ntnu.idatt2001.edvarso.model.units.*;

import java.util.ArrayList;

/**
 * Factory class used to create units
 */
public class UnitFactory {

    /**
     * Creates a new unit
     * @param unitType the unit type
     * @param name the unit's name
     * @param health the unit's health
     * @return a new unit object
     */
    public static Unit getUnit(String unitType, String name, int health) throws IllegalArgumentException {

        if (unitType == null) {
            return null;
        }

        if (unitType.equalsIgnoreCase("InfantryUnit")) {
            return new InfantryUnit(name, health);
        } else if (unitType.equalsIgnoreCase("CavalryUnit")) {
            return new CavalryUnit(name, health);
        } else if (unitType.equalsIgnoreCase("RangedUnit")) {
            return new RangedUnit(name, health);
        } else if (unitType.equalsIgnoreCase("CommanderUnit")) {
            return new CommanderUnit(name, health);
        } else {
            throw new IllegalArgumentException("Invalid unit type");
        }
    }

    /**
     * Creates a list full of new units
     * @param unitType the type of units
     * @param name the name of the units
     * @param health the health of the units
     * @param n the number of units in the list
     * @return a list of units
     */
    public static ArrayList<Unit> getUnits(String unitType, String name, int health, int n)
            throws IllegalArgumentException {

        if (unitType == null) {
            return null;
        }

        ArrayList<Unit> units = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (unitType.equalsIgnoreCase("InfantryUnit")) {
                units.add(new InfantryUnit(name, health));
            } else if (unitType.equalsIgnoreCase("CavalryUnit")) {
                units.add(new CavalryUnit(name, health));
            } else if (unitType.equalsIgnoreCase("RangedUnit")) {
                units.add(new RangedUnit(name, health));
            } else if (unitType.equalsIgnoreCase("CommanderUnit")) {
                units.add(new CommanderUnit(name, health));
            } else {
                throw new IllegalArgumentException("Invalid unit type");
            }
        }

        return units;
    }
}
