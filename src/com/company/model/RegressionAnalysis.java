package com.company.model;

public class RegressionAnalysis {

    Methods methods = new Methods();
    RealData realDataSet1 = (RealData) methods.realDataSet1;
    ForecastData forecast1 = new ForecastData();
    double[] forecast = new double[24];
    /**This method provides to calculate regression analysis */
    public double[] regressionAnalysis(){

        double[] xy = new double[24];
        double[] xx = new double[24];

        double xytoplam = 0;
        for (int i = 0; i < 24; i++) {
            xy[i] = realDataSet1.getByPosition(i).getValue() * (i + 1);
            xytoplam = xytoplam + xy[i];

        }

        double xxtoplam = 0;
        for (int i = 0; i < 24; i++) {
            xx[i] = (i + 1) * (i + 1);
            xxtoplam = xxtoplam + xx[i];

        }
        double ytoplam = 0;
        for (int i = 0; i < 24; i++) {
            ytoplam = realDataSet1.getByPosition(i).getValue() + ytoplam;

        }
        double xtoplam = 0;
        for (int i = 0; i < 24; i++) {
            xtoplam = xtoplam + i + 1;

        }

        double q = (realDataSet1.size() * xytoplam - xtoplam * ytoplam);
        double w = (realDataSet1.size() * xxtoplam - xtoplam * xtoplam);
        double b = q / w;
        double z = ytoplam / 24;
        double aa = (z) - ((b * xtoplam) / realDataSet1.size());

        for (int i = 0; i < 24; i++) {
            forecast1.insert((int) (aa + b * (i + 1)));
        }
        for(int j = 0;j<24;j++){
            forecast[j]=forecast1.getByPosition(j).getValue();
            System.out.println(forecast1.getByPosition(j).getValue());
        }

        return forecast;
    }
}
