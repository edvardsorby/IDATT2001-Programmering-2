package edu.ntnu.idatt2001.edvarso.controller;

import edu.ntnu.idatt2001.edvarso.Application;
import edu.ntnu.idatt2001.edvarso.model.army.Army;
import edu.ntnu.idatt2001.edvarso.model.factory.DialogFactory;
import edu.ntnu.idatt2001.edvarso.model.factory.UnitFactory;
import edu.ntnu.idatt2001.edvarso.model.fileHandler.FileHandler;
import edu.ntnu.idatt2001.edvarso.model.units.Unit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateArmyController implements Initializable {

    @FXML
    private TextField armyNameText;

    @FXML
    private TextField cavalryHealthText;

    @FXML
    private TextField cavalryNameText;

    @FXML
    private Spinner<Integer> cavalryNr;

    @FXML
    private TextField commanderHealthText;

    @FXML
    private TextField commanderNameText;

    @FXML
    private Spinner<Integer> commanderNr;

    @FXML
    private TextField infantryHealthText;

    @FXML
    private TextField infantryNameText;

    @FXML
    private Spinner<Integer> infantryNr;

    @FXML
    private TextField rangedHealthText;

    @FXML
    private TextField rangedNameText;

    @FXML
    private Spinner<Integer> rangedNr;

    private File army1File;
    private File army2File;
    private Army army1;
    private Army army2;


    /**
     * Initializes the page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> infantryValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000);
        SpinnerValueFactory<Integer> rangedValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000);
        SpinnerValueFactory<Integer> cavalryValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000);
        SpinnerValueFactory<Integer> commanderValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000);

        infantryNr.setValueFactory(infantryValueFactory);
        rangedNr.setValueFactory(rangedValueFactory);
        cavalryNr.setValueFactory(cavalryValueFactory);
        commanderNr.setValueFactory(commanderValueFactory);

    }

    /**
     * Navigates back to the army selection menu
     */
    @FXML
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/edvarso/view/armySelection.fxml"));
        Parent root = loader.load();

        Stage stage = Application.stage;
        stage.getScene().setRoot(root);

    }

    /**
     * Saves to a new army file
     */
    @FXML
    private void saveArmy() {
        try {
            ArrayList<Unit> units = new ArrayList<>();

            String armyName = armyNameText.getText();
            int infantryNumber = infantryNr.getValue();
            int rangedNumber = rangedNr.getValue();
            int cavalryNumber = cavalryNr.getValue();
            int commanderNumber = commanderNr.getValue();



            if (infantryNumber > 0) {
                units.addAll(UnitFactory.getUnits("infantryUnit", infantryNameText.getText(),
                        Integer.parseInt(infantryHealthText.getText()), infantryNumber));
            }

            if (rangedNumber > 0) {
                units.addAll(UnitFactory.getUnits("rangedUnit", rangedNameText.getText(),
                        Integer.parseInt(rangedHealthText.getText()), rangedNumber));
            }

            if (cavalryNumber > 0) {
                units.addAll(UnitFactory.getUnits("cavalryUnit", cavalryNameText.getText(),
                        Integer.parseInt(cavalryHealthText.getText()), cavalryNumber));
            }

            if (commanderNumber > 0) {
                units.addAll(UnitFactory.getUnits("commanderUnit", commanderNameText.getText(),
                        Integer.parseInt(commanderHealthText.getText()), commanderNumber));
            }


            Army newArmy = new Army(armyName, units);


            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle("Save army file");
            fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
            fileChooser.setInitialDirectory(new File("src/main/resources/edu/ntnu/idatt2001/edvarso/armies"));

            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                FileHandler.writeToFile(newArmy, file.getPath());

                DialogFactory.showDialog(armyName + " has been saved!");

                back();
            }




        } catch (NumberFormatException e) {
            DialogFactory.showDialog("Make sure all numbers are valid");
        } catch (Exception e) {
            DialogFactory.showDialog(e.getMessage());
        }
    }
}
