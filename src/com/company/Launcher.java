package com.company;

import com.company.controller.ResultOfPredictionController;
import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
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
