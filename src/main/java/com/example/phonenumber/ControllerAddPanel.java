package com.example.phonenumber;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAddPanel {
    @FXML
    TextField textField_name , textField_phoneNumber;
    @FXML
    Stage stage;
    public void save(){
        if (textField_name.getText().equals(""))
            HelloApplication.showMessage("Name contact is empty.","Error");
        else if (textField_phoneNumber.getText().equals(""))
            HelloApplication.showMessage("Phone Number contact is empty.","Error");
        else if (!HelloApplication.checkPhoneNumber(textField_phoneNumber.getText()))
            HelloApplication.showMessage("Phone Number invalid.","Error");
        else if (DataBase.existContact(new Contact(textField_name.getText(),textField_phoneNumber.getText())))
            HelloApplication.showMessage("contact is exist.","Error");
        else{
            Contact contact = new Contact(textField_name.getText(),textField_phoneNumber.getText());
            DataBase.contacts.add(contact);
            HelloApplication.showMessage("contact added successfully.","Info");
            try {
                DataBase.saveToFile(contact);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.close();
        }
    }

}
