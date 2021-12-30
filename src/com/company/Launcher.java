package com.company;

import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;


public class Launcher extends Application {

    public static void main(String[] args) {
        Methods.addData();
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(new Methods());
        viewFactory.showMainWindow();
    }

}
