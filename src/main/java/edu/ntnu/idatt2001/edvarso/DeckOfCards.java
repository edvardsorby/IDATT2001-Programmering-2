package edu.ntnu.idatt2001.edvarso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> cards = new ArrayList<>();
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    public DeckOfCards() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new PlayingCard(suit[j], i));
            }
        }
    }

    public HandOfCards dealHand(int n) {
        Random rand = new Random();

        HandOfCards hand = new HandOfCards();

        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(cards.size());
            hand.addCard(cards.get(j));
            cards.remove(j);
        }

        return hand;
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }
}
