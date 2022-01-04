package com.foracademy.foracademy101fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import JDBC101.serviceImpl.AdminServiceImpl;
public class loginController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public TextField email;
    public TextField password;
    public Label Ealert;
    public Label Palert;
    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        switch (new AdminServiceImpl().Login(email.getText(),password.getText())){
            case 0:
                Ealert.setText("Nous n'avons pas cet email dans nos données !");
                Ealert.setTextFill(Paint.valueOf("#f0932b"));
                email.setStyle("-fx-border-color: #eb4d4b");
                break;
            case 1:
                root = FXMLLoader.load(Main.class.getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 616, 410);
                stage.setTitle("ForAcademy - Hello");
                stage.setScene(scene);
                stage.show();
                break;
            case 2:
                Palert.setText("Le mot de passe n'est pas correct, essayez-en un autre !");
                Palert.setTextFill(Paint.valueOf("#eb4d4b"));
                password.setStyle("-fx-border-color: #eb4d4b");
                break;
        }
    }
}
