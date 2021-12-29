package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Optional;

public class MainWindowController extends BaseController {

    public MainWindowController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName, methods);
    }

    @FXML
    private Label lblError;


    @FXML
    void dataProcessingAction() {
        viewFactory.showDataOperationsController();
    }

    @FXML
    void predictionResultAction() {
        viewFactory.showPredictionControllerWindow();
    }
}