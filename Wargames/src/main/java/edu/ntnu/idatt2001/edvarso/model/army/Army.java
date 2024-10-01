package edu.ntnu.idatt2001.edvarso.model.army;

import edu.ntnu.idatt2001.edvarso.model.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A collection of units that can attack other units in a battle.
 */
public class Army {
    private final String name;
    private ArrayList<Unit> units = new ArrayList<>();

    /**
     * Constructor for the model.army.Army class, which takes the name of the army as a parameter.
     * @param name the name of the army
     */
    public Army(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) throw new IllegalArgumentException("Army name cannot be blank");
        this.name = name;
    }

    /**
     * Constructor for the model.army.Army class, which takes the name of the army as a parameter, in addition to a list of units.
     * @param name the name of the army
     * @param units a list containing units for the army
     */
    public Army(String name, ArrayList<Unit> units) {
        if (name == null || name.equals("")) throw new IllegalArgumentException("Army name cannot be blank");
        this.name = name;
        this.units = units;
    }

    /**
     * Gets the name of the army.
     * @return the name of the army
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a new unit to the army.
     * @param unit a unit that inherits from the superclass units.Unit.
     */
    public void add(Unit unit) {
        units.add(unit);
    }

    /**
     * Adds all units from a list to the chosen army.
     * @param units a list with units
     */
    public void addAll(ArrayList<Unit> units) {
        this.units.addAll(units);
    }

    /**
     * Removes a unit from the chosen army.
     * @param unit the unit to be removed
     */
    public void remove(Unit unit) {
        units.remove(unit);
    }

    /**
     * Checks if the army has any units.
     * @return false or true, depending on if the army is empty or not
     */
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    /**
     * Gets all units that are in the chosen army.
     * @return a list with all the units
     */
    public ArrayList<Unit> getAllUnits() {
        return units;
    }

    /**
     * Gets a random unit from the chosen army.
     * @return a random unit
     */
    public Unit getRandom() {
        Random rand = new Random();
        int i = rand.nextInt(units.size());
        return units.get(i);
    }

    /**
     * Gets all infantry units from the army
     * @return a list of infantry units
     */
    public List<Unit> getInfantryUnits() {
        return units.stream().filter(u -> u instanceof InfantryUnit).collect(Collectors.toList());
    }

    /**
     * Gets all cavalry units from the army
     * Inherited Commander Units are excluded
     * @return a list of cavalry units
     */
    public List<Unit> getCavalryUnits() {
        return units.stream().filter(u -> u instanceof CavalryUnit && !(u instanceof CommanderUnit)).collect(Collectors.toList());
    }

    /**
     * Gets all ranged units from the army
     * @return a list of ranged units
     */
    public List<Unit> getRangedUnits() {
        return units.stream().filter(u -> u instanceof RangedUnit).collect(Collectors.toList());
    }

    /**
     * Gets all commander units from the army
     * @return a list of commander units
     */
    public List<Unit> getCommanderUnits() {
        return units.stream().filter(u -> u instanceof CommanderUnit).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "model.army.Army: " +
                name +
                ", units: " + units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }
}
