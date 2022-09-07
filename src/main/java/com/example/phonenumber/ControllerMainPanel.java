package com.example.phonenumber;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMainPanel {
    public void add() throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("AddPanel.fxml"));
        stage.setTitle("Add Contact");
        stage.show();
    }

}
