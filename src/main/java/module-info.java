module edu.ntnu.idatt2001.ecvarso {
    requires javafx.controls;
    requires javafx.fxml;

    exports edu.ntnu.idatt2001.edvarso;
    exports edu.ntnu.idatt2001.edvarso.controller;
    opens edu.ntnu.idatt2001.edvarso;
}