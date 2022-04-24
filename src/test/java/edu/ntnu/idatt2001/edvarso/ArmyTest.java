package edu.ntnu.idatt2001.edvarso;

import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.units.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArmyTest {

    @Test
    public void addUnit() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));

        assertEquals(1, humanArmy.getAllUnits().size());
    }

    @Test
    public void removeUnit() {
        Army humanArmy = new Army("Human army");

        Unit footman = new InfantryUnit("Footman", 100);

        humanArmy.add(footman);

        humanArmy.remove(footman);

        assertFalse(humanArmy.hasUnits());
    }


    @Test
    public void getRandom() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CavalryUnit("Knight", 100));
        humanArmy.add(new RangedUnit("Archer", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        System.out.println(humanArmy.getRandom());
    }

    @Nested
    class getUnitsTests {

        @Test
        public void getInfantryUnits() {
            InfantryUnit unit1 = new InfantryUnit("Footman", 100);
            InfantryUnit unit2 = new InfantryUnit("Footman", 100);
            InfantryUnit unit3 = new InfantryUnit("Footman", 100);

            Army humanArmy = new Army("Human army");
            humanArmy.add(new CavalryUnit("Knight", 100));
            humanArmy.add(new RangedUnit("Archer", 100));
            humanArmy.add(new CommanderUnit("Mountain King", 180));
            humanArmy.add(unit1);
            humanArmy.add(unit2);
            humanArmy.add(unit3);

            ArrayList<Unit> infantryUnits = new ArrayList<>();
            infantryUnits.add(unit1);
            infantryUnits.add(unit2);
            infantryUnits.add(unit3);

            assertEquals(infantryUnits, humanArmy.getInfantryUnits());
        }

        @Test
        public void getCavalryUnits() {
            CavalryUnit unit1 = new CavalryUnit("Knight", 100);
            CavalryUnit unit2 = new CavalryUnit("Knight", 100);
            CavalryUnit unit3 = new CavalryUnit("Knight", 100);

            Army humanArmy = new Army("Human army");
            humanArmy.add(new InfantryUnit("Footman", 100));
            humanArmy.add(new RangedUnit("Archer", 100));
            humanArmy.add(new CommanderUnit("Mountain King", 180));
            humanArmy.add(unit1);
            humanArmy.add(unit2);
            humanArmy.add(unit3);

            ArrayList<Unit> cavalryUnits = new ArrayList<>();
            cavalryUnits.add(unit1);
            cavalryUnits.add(unit2);
            cavalryUnits.add(unit3);

            assertEquals(cavalryUnits, humanArmy.getCavalryUnits());
        }

        @Test
        public void getCommanderUnits() {
            CommanderUnit unit1 = new CommanderUnit("Mountain King", 180);
            CommanderUnit unit2 = new CommanderUnit("Mountain King", 180);
            CommanderUnit unit3 = new CommanderUnit("Mountain King", 180);

            Army humanArmy = new Army("Human army");
            humanArmy.add(new InfantryUnit("Footman", 100));
            humanArmy.add(new CavalryUnit("Knight", 100));
            humanArmy.add(new RangedUnit("Archer", 100));
            humanArmy.add(unit1);
            humanArmy.add(unit2);
            humanArmy.add(unit3);

            ArrayList<Unit> commanderUnits = new ArrayList<>();
            commanderUnits.add(unit1);
            commanderUnits.add(unit2);
            commanderUnits.add(unit3);

            assertEquals(commanderUnits, humanArmy.getCommanderUnits());
        }
    }

    @Test
    public void writeArmyToFile() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        assertDoesNotThrow(() -> Army.writeToFile(humanArmy, "src/test/resources/human-army.csv"));
    }

    @Test
    public void writeArmyToInvalidPath() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        assertThrows(IllegalArgumentException.class, () -> Army.writeToFile(humanArmy, "invalid-path/human-army.csv"));
    }

    @Test
    public void writeAndReadArmyFromFile() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        System.out.println("Expected: " + humanArmy);
        System.out.println("Result:   " + Army.readFromFile("src/test/resources/human-army.csv"));

        assertEquals(humanArmy, Army.readFromFile("src/test/resources/human-army.csv"));
    }

    @Test
    public void readInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> Army.readFromFile("src/test/resources/invalid-army.csv"));

    }
}
