import edu.ntnu.idatt2001.edvarso.model.HandOfCards;
import edu.ntnu.idatt2001.edvarso.model.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandOfCardsTest {
    @Test
    public void checkCorrectSum() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));

        assertEquals(28,hand.calculateSum());

    }

    @Test
    public void checkWrongSum() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));

        assertNotEquals(27,hand.calculateSum());

    }

    @Test
    public void cardsWithHearts() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('H', 4));
        hand.addCard(new PlayingCard('H', 12));
        hand.addCard(new PlayingCard('C', 5));

        System.out.println(hand.getAllCardsWithSuit('H'));

        assertEquals(3, hand.getAllCardsWithSuit('H').getHand().size());
    }

    @Test
    public void cardsWithOutHearts() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('C', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('S', 4));
        hand.addCard(new PlayingCard('S', 12));
        hand.addCard(new PlayingCard('C', 5));

        System.out.println(hand.getAllCardsWithSuit('H'));
        assertEquals(0, hand.getAllCardsWithSuit('H').getHand().size());
    }

    @Test
    public void queenOfSpadesExists() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));
        hand.addCard(new PlayingCard('S', 12));

        assertTrue(hand.queenOfSpadesExists());

    }

    @Test
    public void queenOfSpadesDoesNotExists() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));

        assertFalse(hand.queenOfSpadesExists());

    }

    @Test
    public void isFlush() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));
        hand.addCard(new PlayingCard('C', 5));
        hand.addCard(new PlayingCard('C', 5));
        hand.addCard(new PlayingCard('C', 5));
        hand.addCard(new PlayingCard('C', 5));

        assertTrue(hand.isFlush());

    }

    @Test
    public void isNotFlush() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('H', 13));
        hand.addCard(new PlayingCard('D', 9));
        hand.addCard(new PlayingCard('C', 5));

        assertFalse(hand.isFlush());
    }
}
