module com.foracademy.foracademy101fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.foracademy.foracademy101fx to javafx.fxml;
    exports com.foracademy.foracademy101fx;
}