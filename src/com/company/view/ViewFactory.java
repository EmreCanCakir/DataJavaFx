package com.company.view;

import com.company.controller.*;
import com.company.model.BaseDataSet;
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
        BaseController controller = new MainWindowController(this, "MainWindow.fxml", methods);
        initializeStage(controller);
    }

    public void showPredictionControllerWindow() {
        BaseController controller = new ResultOfPredictionController(this, "ResultOfPrediction.fxml", methods);
        initializeStage(controller);
    }
    public void showDataOperationsController(){
        BaseController controller = new DataOperationsController(this,"DataOperations.fxml",methods);
        initializeStage(controller);
    }
    public void showReverseOrderController(){
        BaseController controller = new ShowReverseOrderController(this,"ShowReverseOrder.fxml",methods);
        initializeStage(controller);
    }
    public void showMinMaxController(){
        BaseController controller = new ShowMinMaxController(this,"showMinMax.fxml",methods);
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
