module DataJavaFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;

    opens com.company;
    opens com.company.view;
    opens com.company.controller;
}