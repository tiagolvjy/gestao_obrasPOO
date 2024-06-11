module com.example.todoproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.todoproject to javafx.fxml;
    opens com.example.todoproject.models to javafx.base;
    exports com.example.todoproject;
    exports com.example.todoproject.controllers;
    exports com.example.todoproject.models;
    opens com.example.todoproject.controllers to javafx.fxml;
}