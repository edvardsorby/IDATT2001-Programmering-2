import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {

    @Test
    @DisplayName("Test battle between two identical single-unit armies")
    public void testBattleBetweenTwoIdenticalSingleUnitArmies() {

        Army army1 = new Army("Army 1");
        Army army2 = new Army("Army 2");

        army1.add(new InfantryUnit("Unit 1", 100));
        army2.add(new InfantryUnit("Unit 2", 100));

        Battle testBattle = new Battle(army1, army2);

        //Expects Army 1 to win, as the two identical armies consist of only one type of unit,
        // and Army 1 will always attack first.
        assertEquals(army1, testBattle.simulate());
    }

    @Test
    @DisplayName("Simulate a battle")
    public void simulate() {
        Army humanArmy = new Army("Human army");
        for (int i = 0; i < 500; i++) humanArmy.add(new InfantryUnit("Footman", 100));
        for (int i = 0; i < 100; i++) humanArmy.add(new CavalryUnit("Knight", 100));
        for (int i = 0; i < 200; i++) humanArmy.add(new RangedUnit("Archer", 100));
        humanArmy.add(new CommanderUnit("Mountain King", 180));

        Army orcishHorde = new Army("Orcish horde");
        for (int i = 0; i < 500; i++) orcishHorde.add(new InfantryUnit("Grunt", 100));
        for (int i = 0; i < 100; i++) orcishHorde.add(new CavalryUnit("Raider", 100));
        for (int i = 0; i < 200; i++) orcishHorde.add(new RangedUnit("Spearman", 100));
        orcishHorde.add(new CommanderUnit("Gul'dan", 180));

        Battle battle = new Battle(humanArmy, orcishHorde);

        System.out.println(battle.simulate().getName() + " won the battle.");
    }

}
