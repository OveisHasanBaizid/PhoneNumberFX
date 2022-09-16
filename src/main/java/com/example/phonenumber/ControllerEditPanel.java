package com.example.phonenumber;

import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerEditPanel {
    Contact contact;
    @FXML
    TextField textField_name , textField_phoneNumber;
    @FXML
    Stage stage;
    public void initialize(){
        contact = DataBase.editContact;
        textField_name.setText(contact.getName());
        textField_phoneNumber.setText(contact.getPhoneNumber());
    }
    public void cancel(){
        stage.close();
    }
    public void delete() throws IOException {
        DataBase.delete(contact);
        HelloApplication.showMessage("contact deleted successfully.","Info");
        stage.close();
    }
    public void edit(){
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
            DataBase.edit(this.contact , contact);
            HelloApplication.showMessage("contact edited successfully.","Info");
            try {
                DataBase.write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.close();
        }
    }
}
