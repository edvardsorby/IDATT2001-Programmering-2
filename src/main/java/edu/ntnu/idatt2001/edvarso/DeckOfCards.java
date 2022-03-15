package edu.ntnu.idatt2001.edvarso;

import java.util.ArrayList;

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

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }
}
