module edu.ntnu.idatt2001.edvarso {
    requires javafx.controls;
    requires javafx.fxml;

    exports edu.ntnu.idatt2001.edvarso;
    exports edu.ntnu.idatt2001.edvarso.controller;
    exports edu.ntnu.idatt2001.edvarso.model.fileHandler;
    exports edu.ntnu.idatt2001.edvarso.model.army;
    exports edu.ntnu.idatt2001.edvarso.model.units;
    exports edu.ntnu.idatt2001.edvarso.model.battle;
    opens edu.ntnu.idatt2001.edvarso;
    opens edu.ntnu.idatt2001.edvarso.controller;
    opens edu.ntnu.idatt2001.edvarso.model.units to javafx.base;
}