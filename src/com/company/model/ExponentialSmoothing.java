package com.company.model;

public class ExponentialSmoothing {

    Methods methods = new Methods();
    RealData realDataSet1 = (RealData) methods.realDataSet1;
    ForecastData forecast1 = new ForecastData();
    double[] forecast = new double[24];
    //This method provides to calculate exponential smoothing
    public double[] exponentialSmoothing(){
        double a = 0.2;
        forecast1.insert(300);
        for (int i = 0; i < 24; i++) {
            forecast1.insert((a * realDataSet1.getByPosition(i).getValue() + (1 - a) * forecast1.getByPosition(i).getValue()));  //Formul uygulaniyor
        }
        for(int j = 0;j<24;j++){
            forecast[j]=forecast1.getByPosition(j).getValue(); //Elements put to inside array
        }
        return forecast;
    }


}
