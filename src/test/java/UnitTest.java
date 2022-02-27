import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        testUnit1.attack(testUnit2);

        //opponent.getHealth() - (attack + getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        int expectedHealth = 100 - (15 + 2) + (10 + 1);

        assertEquals(expectedHealth, testUnit2.getHealth());
    }

    @Test
    public void testInfantryUnitResistBonus() {
        Unit testUnit = new InfantryUnit("testName1", 100);

        assertEquals(1, testUnit.getResistBonus());
    }

    @Nested
    @DisplayName("Test rangedUnit resistBonuses")
    class testRangedUnitResistBonuses {

        Unit testUnit1 = new RangedUnit("testName1", 100);
        Unit testUnit2 = new RangedUnit("testName2", 100);

        @Test
        @DisplayName("Test rangedUnit resistBonus before any attacks")
        public void testRangedUnitResistBonusBeforeAnyAttacks() {

            assertEquals(6, testUnit1.getResistBonus());
        }

        @Test
        public void testRangedUnitResistBonusAfterOneAttack() {

            testUnit1.attack(testUnit2);

            assertEquals(4, testUnit2.getResistBonus());
        }

        @Test
        public void testRangedUnitResistBonusAfterTwoAttacks() {

            testUnit1.attack(testUnit2);
            testUnit1.attack(testUnit2);

            assertEquals(2, testUnit2.getResistBonus());
        }
    }

}
