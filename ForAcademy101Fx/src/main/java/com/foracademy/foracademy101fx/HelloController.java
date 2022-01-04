package com.foracademy.foracademy101fx;

import JDBC101.serviceImpl.UserServiceImpl;
import JDBC101.serviceImpl.AdminServiceImpl;
import JDBC101.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class HelloController {

    public TableView tableView;

    public HelloController(){
//        UserServiceImpl userService = new UserServiceImpl();
//        AdminServiceImpl adminService = new AdminServiceImpl();
//        tableView.getItems().addAll(userService.getAllUsers());
//        System.out.println(tableView.getItems());
//        tableView.getItems().addAll(adminService.getAllAdmins());
//        System.out.println(tableView.getItems());
    }
    @FXML
    public void getData() throws IOException {
        System.out.println("test");
        System.out.println(tableView.getItems());
    }

}