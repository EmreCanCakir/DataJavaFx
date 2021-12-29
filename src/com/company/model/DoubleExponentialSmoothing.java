package com.company.model;

public class DoubleExponentialSmoothing {
    Methods methods = new Methods();
    RealData realDataSet1 = (RealData) methods.realDataSet1;
    ForecastData forecast1 = new ForecastData();
    double[] forecast = new double[24];

    /**This method provides to calculate double exponential smoothing */
    public double[] doubleExponentialSmoothing() {
        double B = 0.2;
        double[] s0 = new double[24];
        double[] g0 = new double[24];
        s0[0] = 200;
        g0[0] = 50;
        for (int i = 0; i < 24; i++) {
            if (i == 0) {
                s0[0] = 200;
                g0[0] = 50;
            } else {
                double a = 0.2;
                s0[i] = a * realDataSet1.getByPosition(i - 1).getValue() + (1 - a) * (s0[i - 1] + g0[i - 1]);

                g0[i] = B * (s0[i] - s0[i - 1]) + (1 - B) * g0[i - 1];
            }
            forecast1.insert(s0[i] + g0[i]);
        }
        for (int j = 0; j < 24; j++) {
            forecast[j] = forecast1.getByPosition(j).getValue();
        }
        return forecast;
    }
}
