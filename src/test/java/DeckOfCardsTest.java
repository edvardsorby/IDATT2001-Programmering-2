import edu.ntnu.idatt2001.edvarso.DeckOfCards;
import org.junit.jupiter.api.Test;

public class DeckOfCardsTest {

    @Test
    public void createDeckOfCards() {
        DeckOfCards testDeck = new DeckOfCards();
        System.out.println("The deck contains " + testDeck.getCards().size() + " cards.");

        for (int i = 0; i < testDeck.getCards().size(); i++) {
            System.out.println(testDeck.getCards().get(i).getAsString());
        }
    }
}
