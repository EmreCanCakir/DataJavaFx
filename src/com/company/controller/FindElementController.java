package com.company.controller;

import com.company.model.BaseDataSet;
import com.company.model.Methods;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class FindElementController extends BaseController{
    BaseDataSet baseDataSet = new BaseDataSet();

    public FindElementController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName, methods);
    }

    @FXML
    private Label lblResult;

    public void initialize(){
        int index =0;
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("FIND ELEMENT");
        textInputDialog.setHeaderText(null);
        textInputDialog.setContentText("PLEASE ENTER THE MONTH NUMBER");
        Optional<String> result = new TextInputDialog().showAndWait();
        if(result.isPresent()){
            index = Integer.parseInt(result.get());
        }
        baseDataSet.getByPosition(index);
        lblResult.setText(String.valueOf(baseDataSet.getByPosition(index).getValue()));

    }


}
