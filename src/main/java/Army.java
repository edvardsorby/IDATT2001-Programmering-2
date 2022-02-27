import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * A collection of units that can attack other units in a battle.
 */
public class Army {
    private final String name;
    private ArrayList<Unit> units = new ArrayList<Unit>();

    /**
     * Constructor for the Army class, which takes the name of the army as a parameter.
     * @param name the name of the army
     */
    public Army(String name) {
        this.name = name;
    }

    /**
     * Constructor for the Army class, which takes the name of the army as a parameter, in addition to a list of units.
     * @param name the name of the army
     * @param units a list containing units for the army
     */
    public Army(String name, ArrayList<Unit> units) {
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
     * @param unit a unit that inherits from the superclass Unit.
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

    @Override
    public String toString() {
        return "Army: " +
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
