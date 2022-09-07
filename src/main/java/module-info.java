module com.example.phonenumber {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.phonenumber to javafx.fxml;
    exports com.example.phonenumber;
}