package com.company.view;

import com.company.controller.BaseController;
import com.company.controller.MainWindowController;
import com.company.controller.ResultOfPredictionController;
import com.company.model.Methods;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private Methods methods;

    public ViewFactory(Methods methods) {
        this.methods = methods;
    }

    public void showMainWindow() {
        System.out.println("show main window is called. ");
        BaseController controller = new MainWindowController(this, "MainWindow.fxml", methods);
        initializeStage(controller);
    }

    public void showPredictionControllerWindow() {
        System.out.println("show prediction window is called. ");
        BaseController controller = new ResultOfPredictionController(this, "ResultOfPrediction.fxml", methods);
        initializeStage(controller);
    }

    public void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }

}
