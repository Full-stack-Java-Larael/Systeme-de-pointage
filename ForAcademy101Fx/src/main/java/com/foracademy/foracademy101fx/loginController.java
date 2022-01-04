package com.foracademy.foracademy101fx;

import JDBC101.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginController {
    public TextField email;
    public TextField password;
    @FXML
    protected void onLoginButtonClick() throws IOException {
        System.out.println(email.getText());
        System.out.println(password.getText());
    }
}
