package edu.ntnu.idatt2001.edvarso.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class representing a hand of cards.
 */
public class HandOfCards {
    private ArrayList<PlayingCard> hand = new ArrayList<>();

    /**
     * Gets the list of cards in the hand.
     * @return the hand
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Adds a card to the hand.
     * @param card the card to be added
     */
    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    /**
     * Calculates the sum of the faces of the cards in the hand.
     * @return the sum
     */
    public int calculateSum() {
        return hand.stream().map(PlayingCard::getFace).reduce(Integer::sum).get();
    }

    /**
     * Gets all cards with a certain suit.
     * @param suit the suit to be searched for
     * @return all cards in the hand with that suit
     */
    public HandOfCards getAllCardsWithSuit(char suit) {
        List<PlayingCard> reducedHandList = hand.stream().filter(p -> p.getSuit() == suit).toList();

        HandOfCards reducedHand = new HandOfCards();
        reducedHandList.forEach(reducedHand::addCard);

        return reducedHand;
    }

    /**
     * Checks if Queen of spades exists in the hand.
     * @return true or false
     */
    public boolean queenOfSpadesExists() {
        return (hand.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 12));
    }

    /**
     * Checks if the hand is flush (all cards are of the same suit).
     * @return true or false
     */
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
        return String.valueOf(string);
    }
}
