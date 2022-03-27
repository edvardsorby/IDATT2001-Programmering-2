package edu.ntnu.idatt2001.edvarso;

import java.util.ArrayList;
import java.util.List;

public class HandOfCards {
    private ArrayList<PlayingCard> hand = new ArrayList<>();

    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    public int calculateSum() {
        return hand.stream().map(PlayingCard::getFace).reduce(Integer::sum).get();
    }

    public HandOfCards getAllCardsWithSuit(char suit) {
        HandOfCards reducedHand = new HandOfCards();

        List<PlayingCard> reducedHandList = hand.stream().filter(p -> p.getSuit() == suit).toList();

        reducedHandList.forEach(reducedHand::addCard);

        return reducedHand;
    }

    public boolean queenOfSpadesExists() {

        return (hand.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 12));
    }

    public boolean isFlush() {

        return hand.stream().map(PlayingCard::getSuit)
                .anyMatch(suit -> hand.stream().filter(card -> card.getSuit() == suit).count() >= 5);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (PlayingCard playingCard : hand) {
            string.append(" ").append(playingCard);
        }
        return "Hand: " + string;
    }
}
