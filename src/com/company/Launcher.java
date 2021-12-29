package com.company;

import com.company.controller.ResultOfPredictionController;
import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Launcher extends Application {

    public static void main(String[] args) {
        Methods.addData();
        launch(args);

        //ResultOfPredictionController resultOfPredictionController = new ResultOfPredictionController();
        //resultOfPredictionController.initialize();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(new Methods());
        viewFactory.showMainWindow();
    }

}
