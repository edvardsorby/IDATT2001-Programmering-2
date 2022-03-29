package edu.ntnu.idatt2001.edvarso;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ApplicationViewController {

    @FXML
    private TextField cardsOfHeartsText;

    @FXML
    private Button checkHandBtn;

    @FXML
    private Button dealHandBtn;

    @FXML
    private TextField flushText;

    @FXML
    private TextField queenOfSpadesText;

    @FXML
    private TextField sumOfFacesText;

    @FXML
    private Text handTxt;

    DeckOfCards deck = null;
    HandOfCards hand = null;

    @FXML
    private void dealHandClicked() {
        deck = new DeckOfCards();
        hand = deck.dealHand(5);

        handTxt.setText(hand.toString());
        checkHandClicked();
    }

    @FXML
    private void checkHandClicked() {
        if (hand != null) {
            flushText.setText(String.valueOf(hand.isFlush()));
            queenOfSpadesText.setText(String.valueOf(hand.queenOfSpadesExists()));
            sumOfFacesText.setText(String.valueOf(hand.calculateSum()));
            cardsOfHeartsText.setText(String.valueOf(hand.getAllCardsWithSuit('H')));
        }
    }

}

