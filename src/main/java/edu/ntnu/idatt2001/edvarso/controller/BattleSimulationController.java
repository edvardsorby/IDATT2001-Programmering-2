package edu.ntnu.idatt2001.edvarso.controller;

import edu.ntnu.idatt2001.edvarso.Application;
import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.battle.Battle;
import edu.ntnu.idatt2001.edvarso.model.battle.Terrain;
import edu.ntnu.idatt2001.edvarso.model.factory.DialogFactory;
import edu.ntnu.idatt2001.edvarso.model.fileHandler.FileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class BattleSimulationController {


    @FXML
    private Label armyName1Label;

    @FXML
    private Text cavalryUnits1Text;

    @FXML
    private Text commanderUnits1Text;

    @FXML
    private Text infantryUnits1Text;

    @FXML
    private Text rangedUnits1Text;

    @FXML
    private Text totalUnits1Text;

    @FXML
    private TableColumn<?, ?> unitType1Col;

    @FXML
    private TableView<?> units1TableView;

    @FXML
    private TableColumn<?, ?> health1Col;

    @FXML
    private TableColumn<?, ?> name1Col;

    @FXML
    private Label armyName2Label;

    @FXML
    private Text cavalryUnits2Text;

    @FXML
    private Text commanderUnits2Text;

    @FXML
    private Text infantryUnits2Text;

    @FXML
    private Text rangedUnits2Text;

    @FXML
    private Text totalUnits2Text;

    @FXML
    private TableColumn<?, ?> unitType2Col;

    @FXML
    private TableView<?> units2TableView;

    @FXML
    private TableColumn<?, ?> health2Col;

    @FXML
    private TableColumn<?, ?> name2Col;

    @FXML
    private Label winnerLabel;

    @FXML
    private Button simulationBtn;

    @FXML
    private Button resetArmiesBtn;

    @FXML
    private Text terrainText;

    private File army1File;
    private File army2File;
    private Army army1;
    private Army army2;

    private Terrain terrain;


    @FXML
    private void runSimulation() {
        army1 = FileHandler.readFromFile(army1File.getPath());
        army2 = FileHandler.readFromFile(army2File.getPath());

        Battle battle = new Battle(army1, army2, terrain);

        Army winner = battle.simulate();

        winnerLabel.setText("Winner: " + winner.getName());

        displayArmyData();

        simulationBtn.setDisable(true);
        resetArmiesBtn.setDisable(false);

        DialogFactory.showDialog(winner.getName() + " won the battle!");
    }


    @FXML
    private void goToArmySelection() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/edvarso/view/armySelection.fxml"));
        Parent root = loader.load();

        ArmySelectionController controller = loader.getController();
        controller.receiveArmyFiles(army1File, army2File);

        Stage stage = Application.stage;
        stage.getScene().setRoot(root);
    }

    /**
     * Receives army files from a different scene
     * @param army1File the army1 file
     * @param army2File the army2 file
     * @param terrain the terrain where the battle takes place
     */
    public void receiveArmyFiles(File army1File, File army2File, Terrain terrain) {
        this.army1File = army1File;
        this.army2File = army2File;
        this.terrain = terrain;

        army1 = FileHandler.readFromFile(army1File.getPath());
        army2 = FileHandler.readFromFile(army2File.getPath());

        displayArmyData();
        terrainText.setText("Terrain: " + terrain.toString().toLowerCase());
    }

    /**
     * Displays information about the chosen armies
     */
    private void displayArmyData() {
        if (army1 != null) {
            armyName1Label.setText(army1.getName());
            totalUnits1Text.setText("Total units: " + army1.getAllUnits().size());
            infantryUnits1Text.setText("Infantry units: " + army1.getInfantryUnits().size());
            rangedUnits1Text.setText("Ranged units: " + army1.getRangedUnits().size());
            cavalryUnits1Text.setText("Cavalry units: " + army1.getCavalryUnits().size());
            commanderUnits1Text.setText("Commander units: " + army1.getCommanderUnits().size());

            unitType1Col.setCellValueFactory(new PropertyValueFactory<>("unitType"));
            name1Col.setCellValueFactory(new PropertyValueFactory<>("name"));
            health1Col.setCellValueFactory(new PropertyValueFactory<>("health"));

            ObservableList units1ObservableList = FXCollections.observableList(army1.getAllUnits());

            units1TableView.setItems(units1ObservableList);
        }
        if (army2 != null) {
            armyName2Label.setText(army2.getName());
            totalUnits2Text.setText("Total units: " + army2.getAllUnits().size());
            infantryUnits2Text.setText("Infantry units: " + army2.getInfantryUnits().size());
            rangedUnits2Text.setText("Ranged units: " + army2.getRangedUnits().size());
            cavalryUnits2Text.setText("Cavalry units: " + army2.getCavalryUnits().size());
            commanderUnits2Text.setText("Commander units: " + army2.getCommanderUnits().size());

            unitType2Col.setCellValueFactory(new PropertyValueFactory<>("unitType"));
            name2Col.setCellValueFactory(new PropertyValueFactory<>("name"));
            health2Col.setCellValueFactory(new PropertyValueFactory<>("health"));

            ObservableList units1ObservableList = FXCollections.observableList(army2.getAllUnits());

            units2TableView.setItems(units1ObservableList);
        }
    }

    /**
     * Resets the armies to their pre-battle status
     */
    @FXML
    private void resetArmies() {
        army1 = FileHandler.readFromFile(army1File.getPath());
        army2 = FileHandler.readFromFile(army2File.getPath());

        displayArmyData();

        simulationBtn.setDisable(false);
        resetArmiesBtn.setDisable(true);

        winnerLabel.setText("");
    }
}
