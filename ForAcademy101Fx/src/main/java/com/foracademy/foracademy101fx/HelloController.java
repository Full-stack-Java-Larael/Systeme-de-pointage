package com.foracademy.foracademy101fx;

import JDBC101.serviceImpl.AdminServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(new AdminServiceImpl().getAllAdmins().get(0).getEmail());
    }
}