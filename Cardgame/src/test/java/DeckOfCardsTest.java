import edu.ntnu.idatt2001.edvarso.model.DeckOfCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

    @Test
    public void createDeckOfCards() {
        DeckOfCards testDeck = new DeckOfCards();
        System.out.println("The deck contains " + testDeck.getCards().size() + " cards.");

        for (int i = 0; i < testDeck.getCards().size(); i++) {
            System.out.println(testDeck.getCards().get(i).getAsString());
        }
    }

    @Test
    public void dealHand() {
        DeckOfCards testDeck = new DeckOfCards();
        System.out.println("The deck contains " + testDeck.getCards().size() + " cards.");

        System.out.println("Dealt hand: " + testDeck.dealHand(10));
        assertEquals(42, testDeck.getCards().size());
    }

    @Test
    public void handIsEmpty() {
        DeckOfCards testDeck = new DeckOfCards();
        System.out.println("The deck contains " + testDeck.getCards().size() + " cards.");

        for (int i = 0; i < 6; i++) {
            System.out.println("Hand " + (i+1) + ": " + testDeck.dealHand(10));
        }

        System.out.println("The deck contains " + testDeck.getCards().size() + " cards.");
        assertEquals(0, testDeck.getCards().size());
    }
}
