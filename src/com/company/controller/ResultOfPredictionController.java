package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultOfPredictionController extends BaseController {

    @FXML
    private ListView<String> predictionList;

    String[] food ={"pizza", "sushi","apple","pizza", "sushi","apple","pizza", "sushi","apple","pizza", "sushi","apple","pizza", "sushi","apple"};

    public ResultOfPredictionController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName,methods);
    }

    public void initialize(){
        predictionList.getItems().addAll(food);
    }

}
