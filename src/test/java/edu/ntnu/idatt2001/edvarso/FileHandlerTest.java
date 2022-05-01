package edu.ntnu.idatt2001.edvarso;

import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.fileHandler.FileHandler;
import edu.ntnu.idatt2001.edvarso.model.units.CommanderUnit;
import edu.ntnu.idatt2001.edvarso.model.units.InfantryUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileHandlerTest {

    @Test
    public void writeArmyToFile() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        assertDoesNotThrow(() -> FileHandler.writeToFile(humanArmy, "src/test/resources/human-army.csv"));
    }

    @Test
    public void writeArmyToInvalidPath() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        assertThrows(IllegalArgumentException.class, () -> FileHandler.writeToFile(humanArmy, "invalid-path/human-army.csv"));
    }

    @Test
    public void writeAndReadArmyFromFile() {
        Army humanArmy = new Army("Human army");
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new InfantryUnit("Footman", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        System.out.println("Expected: " + humanArmy);
        System.out.println("Result:   " + FileHandler.readFromFile("src/test/resources/human-army.csv"));

        assertEquals(humanArmy, FileHandler.readFromFile("src/test/resources/human-army.csv"));
    }

    @Test
    public void readInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> FileHandler.readFromFile("src/test/resources/invalid-army.csv"));

    }
}
