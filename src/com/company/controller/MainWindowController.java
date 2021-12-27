package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainWindowController extends BaseController{

    public MainWindowController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName,methods );
    }

    @FXML
    private Label lblError;


    @FXML
    void dataProcessingAction() {

    }

    @FXML
    void predictionResultAction() {
        viewFactory.showPredictionControllerWindow();

    }
}