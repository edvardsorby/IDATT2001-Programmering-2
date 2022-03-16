package edu.ntnu.idatt2001.edvarso;

import java.util.ArrayList;

public class HandOfCards {
    private ArrayList<PlayingCard> hand = new ArrayList<>();

    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            string.append(" " + hand.get(i));
        }
        return "Hand: " + string;
    }
}
