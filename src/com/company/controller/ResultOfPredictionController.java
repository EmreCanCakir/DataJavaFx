package com.company.controller;

import com.company.model.*;
import com.company.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ResultOfPredictionController extends BaseController {

    @FXML
    private ListView<Double> predictionList;
    BaseDataSet dataSet = new RealData();
    Methods methods = new Methods();
    Double[] elements = new Double[24];

    public ResultOfPredictionController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        super(viewFactory, fxmlName,methods);
    }

    public void initialize(){
        ExponentialSmoothing exponentialSmoothing = new ExponentialSmoothing();
        DoubleExponentialSmoothing doubleExponentialSmoothing = new DoubleExponentialSmoothing();
        RegressionAnalysis regressionAnalysis = new RegressionAnalysis();
        DeseasonalizedRegressionAnalysis deseasonalizedRegressionAnalysis = new DeseasonalizedRegressionAnalysis();
        if(methods.resultOfMse()==1){
            for(int i=0;i<24;i++){
                elements[i] = exponentialSmoothing.exponentialSmoothing()[i];
            }
            predictionList.getItems().addAll(elements);
        }else if(methods.resultOfMse()==2){
            for(int i=0;i<24;i++){
                elements[i] = doubleExponentialSmoothing.doubleExponentialSmoothing()[i];
            }
            predictionList.getItems().addAll(elements);
        }else if(methods.resultOfMse()==3){
            for(int i=0;i<24;i++){
                elements[i] = regressionAnalysis.regressionAnalysis()[i];
            }
            predictionList.getItems().addAll(elements);
        }else {
            for(int i=0;i<24;i++){
                elements[i] = deseasonalizedRegressionAnalysis.deseasonalizedRegressionAnalysis()[i];
            }
            predictionList.getItems().addAll(elements);
        }

    }

}
