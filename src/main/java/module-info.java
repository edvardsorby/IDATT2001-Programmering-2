module edu.ntnu.idatt2001.edvarso {
    requires javafx.controls;
    requires javafx.fxml;

    exports edu.ntnu.idatt2001.edvarso;
    opens edu.ntnu.idatt2001.edvarso to javafx.fxml;

}