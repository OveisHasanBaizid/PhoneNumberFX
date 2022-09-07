package com.example.phonenumber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("PhoneNumber");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showMessage(String message , String type) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (type.equals("Error"))
            alert.setAlertType(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.getDialogPane().setPrefSize(300, 100);
        alert.setTitle(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkPhoneNumber(String phoneNumber){
        int n = phoneNumber.length();
        if (n<11)
            return false;
        for (int i = 0; i < phoneNumber.length() ; i++) {
            if (!Character.isDigit(phoneNumber.charAt(i)))
                return false;
        }
        return true;
    }
}