package com.example.phonenumber;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ControllerMainPanel {
    @FXML
    TextField search;
    @FXML
    TableView<Contact> tableView;
    @FXML
    TableColumn column_number , column_name , column_phoneNumber;
    public void initialize() throws IOException {
        DataBase.read();
        showTableContact();
    }
    public void showTableContact(){

        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_name.setStyle("-fx-Alignment: CENTER;");

        column_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        column_phoneNumber.setStyle("-fx-Alignment: CENTER;");

        column_number.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>) p ->
                new ReadOnlyObjectWrapper(Integer.parseInt(tableView.getItems().indexOf(p.getValue()) + "")+1));
        column_number.setStyle("-fx-Alignment: CENTER;");

        tableView.setEditable(false);
        ObservableList<Contact> observableList = FXCollections.observableArrayList(DataBase.getContacts(search.getText()));
        tableView.setItems(observableList);
    }
    public void add() throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("AddPanel.fxml"));
        stage.setTitle("Add Contact");
        stage.show();
        new Thread(() -> {
            while (stage.isShowing()){

            }
            showTableContact();
        }).start();
    }

    public void search() {
        showTableContact();
    }

    public void selectContact(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount()==2 && !tableView.getSelectionModel().isEmpty()){
            DataBase.editContact = tableView.getSelectionModel().getSelectedItem();
            Stage stage = FXMLLoader.load(getClass().getResource("EditPanel.fxml"));
            stage.setTitle("Edit Contact");
            stage.show();
            new Thread(() -> {
                while (stage.isShowing()){

                }
                showTableContact();
            }).start();
        }
    }
}
