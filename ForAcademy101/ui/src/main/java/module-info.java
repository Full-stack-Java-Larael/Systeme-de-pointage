module com.foracademy.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.foracademy.ui to javafx.fxml;
    exports com.foracademy.ui;
}