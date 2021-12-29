package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ShowReverseOrderController extends BaseController {
    public ShowReverseOrderController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName, methods);
    }

    @FXML
    private ListView<Double> LvReverse;

    Methods methods = new Methods();
    Double[] elements = new Double[24];

    public void initialize() {
        for (int i = 0; i < 24; i++) {
            elements[i] = methods.reverse()[i];
        }
        LvReverse.getItems().addAll(elements);
    }


}
