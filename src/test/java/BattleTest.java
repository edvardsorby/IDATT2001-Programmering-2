import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import units.*;

public class BattleTest {
    //TODO: Use @BeforeEach to fill in test data before every test.
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

    @Test
    @DisplayName("Probability test")
    public void probabilityTest() {
        int humanWins = 0;
        int orcWins = 0;

        for (int j = 0; j < 1000; j++) {
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

            if (battle.simulate().equals(humanArmy)) {
                humanWins++;
            } else {
                orcWins++;
            }

        }

        System.out.println("Human army wins: " + humanWins);
        System.out.println("Orcish horde wins: " + orcWins);

    }
}
