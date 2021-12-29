package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ShowMinMaxController extends BaseController {

    @FXML
    private Label lblMaximumElement;

    @FXML
    private Label lblMinimumElement;

    public ShowMinMaxController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName, methods);
    }

    public void initialize() {
        Methods methods = new Methods();
        try {
            String min = String.valueOf(methods.findMinimum());
            String max = String.valueOf(methods.findMaximum());
            lblMinimumElement.setText(min);
            lblMaximumElement.setText(max);

        } catch (NullPointerException e) {
            e.getMessage();
        }


    }
}
