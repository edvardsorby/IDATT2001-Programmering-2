package edu.ntnu.idatt2001.edvarso.model.fileHandler;

import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.units.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    /**
     * Method to write an army to a file
     * @param army the army to be written
     * @param targetFile the path of the target file
     */
    public static void writeToFile(Army army, String targetFile) throws IllegalArgumentException{
        try (FileWriter fileWriter = new FileWriter(targetFile)) {
            StringBuilder string = new StringBuilder(army.getName() + "\n");
            for (Unit unit : army.getAllUnits()) {
                string.append(unit.getClass().getSimpleName()).append(",").append(unit.getName())
                        .append(",").append(unit.getHealth()).append("\n");
            }
            fileWriter.write(String.valueOf(string));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file path");
        }
    }

    /**
     * Method to read an army from a file
     * @param file the path to the file containing an army
     */
    public static Army readFromFile(String file) throws IllegalArgumentException{
        if (!file.endsWith(".csv")) {
            throw new IllegalArgumentException("The file has to be a CSV file");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<Unit> newUnits = new ArrayList<>();
            String armyName = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] unitString = line.split(",");
                String unitType = unitString[0];
                String unitName = unitString[1];
                int unitHealth = Integer.parseInt(unitString[2]);

                Unit newUnit = switch (unitType) {
                    case "InfantryUnit" -> new InfantryUnit(unitName, unitHealth);
                    case "CavalryUnit" -> new CavalryUnit(unitName, unitHealth);
                    case "RangedUnit" -> new RangedUnit(unitName, unitHealth);
                    case "CommanderUnit" -> new CommanderUnit(unitName, unitHealth);
                    default -> null;
                };
                newUnits.add(newUnit);
            }
            return new Army(armyName, newUnits);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid army file");
        }
    }
}
