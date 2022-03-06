import org.junit.jupiter.api.Test;
import units.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
