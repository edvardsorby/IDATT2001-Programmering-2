package edu.ntnu.idatt2001.edvarso.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class representing a deck of cards.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> cards = new ArrayList<>();

    /**
     * Instantiates a new deck with 52 cards.
     */
    public DeckOfCards() {
        char[] suit = {'S', 'H', 'D', 'C'};
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new PlayingCard(suit[j], i));
            }
        }
    }

    /**
     * Deals a hand of cards.
     *
     * @param n the number of cards to be dealt
     * @return the hand
     * @throws IllegalArgumentException if the number of requested cards is less than 5
     */
    public HandOfCards dealHand(int n) throws IllegalArgumentException {
        if (n < 5) throw new IllegalArgumentException("You must deal at least 5 cards.");

        Random rand = new Random();

        HandOfCards hand = new HandOfCards();

        for (int i = 0; i < n; i++) {
            if (cards.size() > 0) {
                int j = rand.nextInt(cards.size());
                hand.addCard(cards.get(j));
                cards.remove(j);
            }
        }

        return hand;
    }

    /**
     * Gets all the cards in the hand.
     * @return a list of cards
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }
}
