package com.company.model;

public class DeseasonalizedRegressionAnalysis {

    Methods methods = new Methods();
    RealData realDataSet1 = (RealData) methods.realDataSet1;
    ForecastData forecast1 = new ForecastData();
    double[] forecast = new double[24];
    /**This method provides to calculate deseasionalized analysis */
    public double[] deseasonalizedRegressionAnalysis(){
        double all = 0;
        for (int i = 0; i < 24; i++) {
            all = realDataSet1.getByPosition(i).getValue() + all;
        }
        all = all / realDataSet1.size();
        double[] seasonal = new double[12];
        for (int i = 0; i < 12; i++) {
            seasonal[i] = ((realDataSet1.getByPosition(i).getValue() + realDataSet1.getByPosition(i + 12).getValue()) / 2) / all;

        }

        double[] deseason = new double[24];
        for (int i = 0; i < 24; i++) {
            deseason[i] = realDataSet1.getByPosition(i).getValue() / seasonal[i % 12];
        }
        double sumOfY = 0;
        for (int i = 0; i < 24; i++) {
            sumOfY = deseason[i] + sumOfY;
        }
        int sumOfX = 0;
        for (int i = 0; i < 24; i++) {
            sumOfX = sumOfX + i + 1;
        }
        double[] xy = new double[24];
        int[] xSquare = new int[24];

        int sumOfXSquare = 0;
        for (int i = 0; i < 24; i++) {
            xSquare[i] = (i + 1) * (i + 1);
            sumOfXSquare = sumOfXSquare + xSquare[i];
        }

        double SumOfXY = 0;
        for (int i = 0; i < 24; i++) {
            xy[i] = deseason[i] * (i + 1);
            SumOfXY = SumOfXY + xy[i];
        }

        double b = (realDataSet1.size() * SumOfXY - sumOfX * sumOfY) / (realDataSet1.size() * sumOfXSquare - sumOfX * sumOfX);

        double aa = sumOfY / realDataSet1.size() - b * sumOfX / realDataSet1.size();

        for (int i = 0; i < 24; i++) {
            forecast1.insert(((aa + b * (i + 1)) * seasonal[i % 12]));
        }
        for(int j = 0;j<24;j++){
            forecast[j]=forecast1.getByPosition(j).getValue();
        }
        return forecast;

    }


}
