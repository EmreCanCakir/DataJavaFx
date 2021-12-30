package com.company.controller;

import com.company.model.BaseDataSet;
import com.company.model.Methods;
import com.company.model.RealData;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class DataOperationsController extends BaseController {
    Methods methods = new Methods();
    BaseDataSet baseDataSet = new BaseDataSet();
    @FXML
    private Label lblError;

    public DataOperationsController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName, methods);
    }

    @FXML
    void btnDeleteAllData() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("ARE YOU SURE YOU WANT TO DELETE ALL THE DATA?");
        ButtonType buttonType = new ButtonType("YES");
        ButtonType buttonType1 = new ButtonType("CANCEL");
        alert.getButtonTypes().setAll(buttonType, buttonType1);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType){
            if(methods.deleteAll()==true){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("INFORMANTION");
                alert1.setHeaderText(null);
                alert1.setContentText("ALL OF DATA IS DELETED ");
                alert1.show();
            }else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("ERROR!!!");
                alert2.setHeaderText(null);
                alert2.setContentText("DATASET COULD NOT BE DELETED");
                alert2.show();
            }

        }else if(result.get()==buttonType1){
            alert.close();
        }
    }

    @FXML
    void btnReverseData() {
        viewFactory.showReverseOrderController();
    }

    @FXML
    void btnShowMaxMin() {
        viewFactory.showMinMaxController();
    }

    @FXML
    void btnFindElement() {
        viewFactory.findElement();
    }

    @FXML
    void btnUpdateData() {
        int index =0;
        double value = 0;
        TextInputDialog textInputDialog = new TextInputDialog("month");
        textInputDialog.setTitle("UPDATE MONTH");
        textInputDialog.setHeaderText(null);
        textInputDialog.setContentText("PLEASE ENTER THE MONTH NUMBER");
        Optional<String> result = textInputDialog.showAndWait();
        TextInputDialog textInputDialog1 = new TextInputDialog();
        textInputDialog1.setTitle("UPDATE VALUE");
        textInputDialog.setHeaderText(null);
        textInputDialog.setContentText("PLEASE ENTER THE VALUE");
        Optional<String> result1 = textInputDialog1.showAndWait();
        if(result.isPresent()){
            index= Integer.parseInt(result.get());
        }
        if(result1.isPresent()){
            value = Double.parseDouble(result1.get());
        }
        methods.update(index,value);
    }
}
