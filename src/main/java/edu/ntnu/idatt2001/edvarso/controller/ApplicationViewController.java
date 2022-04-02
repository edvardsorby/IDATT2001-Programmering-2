package edu.ntnu.idatt2001.edvarso.controller;

import edu.ntnu.idatt2001.edvarso.model.DeckOfCards;
import edu.ntnu.idatt2001.edvarso.model.HandOfCards;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The Application view controller.
 */
public class ApplicationViewController {

    @FXML
    private TextField cardsOfHeartsText;

    @FXML
    private TextField flushText;

    @FXML
    private TextField queenOfSpadesText;

    @FXML
    private TextField sumOfFacesText;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;

    DeckOfCards deck = null;
    HandOfCards hand = null;

    /**
     * Deals a hand when the user clicks on the "Deal hand" button.
     * @throws FileNotFoundException if it fails to locate an image file
     */
    @FXML
    private void dealHandClicked() throws FileNotFoundException {
        deck = new DeckOfCards();
        hand = deck.dealHand(5);

        clearTextFields();

        card1.setImage(newImage(0));
        card2.setImage(newImage(1));
        card3.setImage(newImage(2));
        card4.setImage(newImage(3));
        card5.setImage(newImage(4));
    }

    /**
     * Fills in the text fields with information when the "Check hand" button is clicked.
     */
    @FXML
    private void checkHandClicked() {
        if (hand != null) {
            sumOfFacesText.setText(String.valueOf(hand.calculateSum()));
            cardsOfHeartsText.setText(String.valueOf(hand.getAllCardsWithSuit('H')));
            queenOfSpadesText.setText((hand.queenOfSpadesExists()) ? "Yes" : "No");
            flushText.setText((hand.isFlush()) ? "Yes" : "No");
        } else {
            showInformationDialog("Please deal a hand first.");
        }
    }

    /**
     * Clears the text fields in the program.
     */
    private void clearTextFields() {
        flushText.setText("");
        queenOfSpadesText.setText("");
        sumOfFacesText.setText("");
        cardsOfHeartsText.setText("");
    }

    /**
     * Creates a new image object.
     * @param imageNr the number of the image in the user interface
     * @return an image object
     * @throws FileNotFoundException if it fails to locate the image file
     */
    private Image newImage(int imageNr) throws FileNotFoundException {
        return new Image(new FileInputStream("src/main/resources/images/" + hand.getHand().get(imageNr) + ".png"));
    }

    /**
     * Shows an information dialog to the user.
     * @param text the text to be displayed
     */
    public static void showInformationDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Card game");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

}

