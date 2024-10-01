package edu.ntnu.idatt2001.edvarso.controller;

import edu.ntnu.idatt2001.edvarso.Application;
import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.battle.Terrain;
import edu.ntnu.idatt2001.edvarso.model.factory.DialogFactory;
import edu.ntnu.idatt2001.edvarso.model.fileHandler.FileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArmySelectionController implements Initializable {


    @FXML
    private Label armyName1Label;

    @FXML
    private Text cavalryUnits1Text;

    @FXML
    private Text commanderUnits1Text;

    @FXML
    private Text fileSelected1Text;

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
    private Text fileSelected2Text;

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
    private ComboBox terrainComboBox;

    private File army1File;
    private File army2File;
    private Army army1;
    private Army army2;

    /**
     * Initializes the controller
     * Fills the combobox with the correct terrain types
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrainComboBox.setItems(FXCollections.observableArrayList(Terrain.values()));
    }

    /**
     * Selects army 1
     */
    @FXML
    private void selectArmy1() {
        File file = selectArmyFile();

        if (file != null) {
            try {
                army1File = file;
                army1 = FileHandler.readFromFile(army1File.getPath());
                displayArmyData();
            } catch (Exception e) {
                DialogFactory.showDialog(e.getMessage());
            }
        }

    }

    /**
     * Selects army 2
     */
    @FXML
    private void selectArmy2() {
        File file = selectArmyFile();

        if (file != null) {
            try {
                army2File = file;
                army2 = FileHandler.readFromFile(army2File.getPath());
                displayArmyData();
            } catch (Exception e) {
                DialogFactory.showDialog(e.getMessage());
            }
        }

    }

    /**
     * Changes the scene to the battle simulation
     */
    @FXML
    private void goToSimulation() throws IOException {
        if (army1 != null && army2 != null && terrainComboBox.getValue() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/edvarso/view/battleSimulation.fxml"));
            Parent root = loader.load();

            BattleSimulationController controller = loader.getController();



            controller.receiveArmyFiles(army1File, army2File, (Terrain) terrainComboBox.getValue());

            Stage stage = Application.stage;
            stage.getScene().setRoot(root);
        } else {
            DialogFactory.showDialog("Please select both armies and the terrain");
        }
    }

    /**
     * Lets the user select a file containing an army
     * @return the selected file
     */
    private File selectArmyFile() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Select army file");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
        fileChooser.setInitialDirectory(new File("src/main/resources/edu/ntnu/idatt2001/edvarso/armies"));

        return fileChooser.showOpenDialog(null);
    }

    /**
     * Displays information about the chosen armies
     */
    private void displayArmyData() {
        if (army1 != null) {
            fileSelected1Text.setText("File selected: " + army1File.getName());
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
            fileSelected2Text.setText("File selected: " + army2File.getName());
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
     * Receives army files from a different scene
     * @param army1File the army1 file
     * @param army2File the army2 file
     */
    public void receiveArmyFiles(File army1File, File army2File) {
        this.army1File = army1File;
        this.army2File = army2File;

        army1 = FileHandler.readFromFile(army1File.getPath());
        army2 = FileHandler.readFromFile(army2File.getPath());

        displayArmyData();
    }

    /**
     * Changes the scene to the "create new army" page
     */
    @FXML
    public void createNewArmy() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/edvarso/view/createArmy.fxml"));
        Parent root = loader.load();

        Stage stage = Application.stage;
        stage.getScene().setRoot(root);

    }

}
