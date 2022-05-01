package edu.ntnu.idatt2001.edvarso;

import edu.ntnu.idatt2001.edvarso.model.factory.UnitFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import edu.ntnu.idatt2001.edvarso.model.units.InfantryUnit;
import edu.ntnu.idatt2001.edvarso.model.units.RangedUnit;
import edu.ntnu.idatt2001.edvarso.model.units.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest {

    @Test
    @DisplayName("Set new health")
    public void setNewHealth() {
        Unit testUnit = new InfantryUnit("testName", 100);

        testUnit.setHealth(120);

        assertEquals(120, testUnit.getHealth());
    }

    @Test
    @DisplayName("Test an attack")
    public void testAttack() {
        Unit testUnit1 = new InfantryUnit("testName1", 100);
        Unit testUnit2 = new InfantryUnit("testName2", 100);

        testUnit1.attack(testUnit2, "HILL");

        // Formula:
        // health[defender] - (attack + attackBonus)[attacker] + (armor + resistBonus)[defender];
        int expectedHealth = 100 - (15 + 2) + (10 + 1);

        assertEquals(expectedHealth, testUnit2.getHealth());
    }

    @Test
    public void testInfantryUnitResistBonus() {
        Unit testUnit = new InfantryUnit("testName1", 100);

        assertEquals(1, testUnit.getResistBonus("HILL"));
    }

    @Nested
    @DisplayName("Test rangedUnit resistBonuses")
    class testRangedUnitResistBonuses {

        Unit testUnit1 = new RangedUnit("testName1", 100);
        Unit testUnit2 = new RangedUnit("testName2", 100);

        @Test
        @DisplayName("Test rangedUnit resistBonus before any attacks")
        public void testRangedUnitResistBonusBeforeAnyAttacks() {

            assertEquals(6, testUnit1.getResistBonus("PLAINS"));
        }

        @Test
        public void testRangedUnitResistBonusAfterOneAttack() {

            testUnit1.attack(testUnit2, "PLAINS");

            assertEquals(4, testUnit2.getResistBonus("PLAINS"));
        }

        @Test
        public void testRangedUnitResistBonusAfterTwoAttacks() {

            testUnit1.attack(testUnit2, "PLAINS");
            testUnit1.attack(testUnit2, "PLAINS");

            assertEquals(2, testUnit2.getResistBonus("PLAINS"));
        }

    }

    @Nested
    @DisplayName("Invalid units.Unit variables")
    class invalidUnitVariables {

        @Test
        public void nameIsInvalid() {
            assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("", 1, 1, 1));
        }

        @Test
        public void healthIsInvalid() {
            assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("Name", 0, 1, 1));
        }

        @Test
        public void attackIsInvalid() {
            assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("Name", 1, 0, 1));
        }

        @Test
        public void armorIsInvalid() {
            assertThrows(IllegalArgumentException.class, () -> new InfantryUnit("Name", 1, 1, -1));
        }


    }

    @Nested
    @DisplayName("Terrain type bonus tests")
    class terrainTypeBonusTests {
        Unit infantryUnit = UnitFactory.getUnit("InfantryUnit", "Infantry unit", 100);
        Unit rangedUnit = UnitFactory.getUnit("RangedUnit", "Infantry unit", 100);
        Unit cavalryUnit = UnitFactory.getUnit("CavalryUnit", "Infantry unit", 100);

        @Test
        public void infantryUnitForestAttackBonus() {
            assertEquals(4, infantryUnit.getAttackBonus("FOREST"));
        }

        @Test
        public void infantryUnitForestResistBonus() {
            assertEquals(2, infantryUnit.getResistBonus("FOREST"));
        }

        @Test
        public void rangedUnitHillAttackBonus() {
            assertEquals(6, rangedUnit.getAttackBonus("HILL"));
        }

        @Test
        public void rangedUnitForestAttackBonus() {
            assertEquals(1, rangedUnit.getAttackBonus("FOREST"));
        }

        @Test
        public void cavalryUnitPlainsAttackBonus() {
            assertEquals(8, cavalryUnit.getAttackBonus("PLAINS"));
        }

        @Test
        public void cavalryUnitForestResistBonus() {
            assertEquals(0, cavalryUnit.getResistBonus("FOREST"));
        }
    }

    @Test
    public void getCorrectUnitType() {
        Unit testUnit = UnitFactory.getUnit("commanderUnit", "Soldier", 100);
        assertEquals("Commander unit", testUnit.getUnitType());
    }
}
