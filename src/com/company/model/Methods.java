package com.company.model;

import javafx.scene.control.Alert;

public class Methods {

    static BaseDataSet realDataSet1 = new RealData();
    static BaseDataSet realdataSet2 = new RealData();

    //This method add elements
    public static void addData() {
        realDataSet1.insert(300);
        realDataSet1.insert(350);
        realDataSet1.insert(330);
        realDataSet1.insert(340);
        realDataSet1.insert(390);
        realDataSet1.insert(430);
        realDataSet1.insert(480);
        realDataSet1.insert(460);
        realDataSet1.insert(490);
        realDataSet1.insert(510);
        realDataSet1.insert(550);
        realDataSet1.insert(560);
        realDataSet1.insert(550);
        realDataSet1.insert(590);
        realDataSet1.insert(600);
        realDataSet1.insert(610);
        realDataSet1.insert(630);
        realDataSet1.insert(620);
        realDataSet1.insert(680);
        realDataSet1.insert(690);
        realDataSet1.insert(710);
        realDataSet1.insert(730);
        realDataSet1.insert(740);
        realDataSet1.insert(770);
    }

    //This method provides add data to dataset2
    public static void addData2() {
        realdataSet2.insert(200);
        realdataSet2.insert(300);
        realdataSet2.insert(250);
        realdataSet2.insert(600);
        realdataSet2.insert(650);
        realdataSet2.insert(670);
        realdataSet2.insert(400);
        realdataSet2.insert(440);
        realdataSet2.insert(430);
        realdataSet2.insert(900);
        realdataSet2.insert(980);
        realdataSet2.insert(990);
        realdataSet2.insert(300);
        realdataSet2.insert(370);
        realdataSet2.insert(380);
        realdataSet2.insert(710);
        realdataSet2.insert(730);
        realdataSet2.insert(790);
        realdataSet2.insert(450);
        realdataSet2.insert(480);
        realdataSet2.insert(490);
        realdataSet2.insert(930);
        realdataSet2.insert(960);
        realdataSet2.insert(980);
    }

    //This method provides to calculate mse
    public double mse(double[] forecast) {
        double mse = 0;
        double sum = 0;
        double[] squaredError = new double[24];
        for (int i = 0; i < 24; i++) {
            squaredError[i] = Math.pow(forecast[i] - realDataSet1.getByPosition(i).getValue(), 2);
            sum += squaredError[i];
        }
        mse = sum / 24;
        return mse;
    }

    //This method provides to find max element
    public double findMaximum() {
        BaseDataSet dataSet = realDataSet1;
        double maximum = 0;
        // BaseDataSet baseDataSet = realDataSet1;
        if (dataSet.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("DATASET IS EMPTY SO YOU DON'T GET MAX ELEMENT");
        } else {
            Element current = dataSet.head;

            while (current != null) {
                if (current.getValue() > maximum) {
                    maximum = current.getValue();
                }
                current = current.next;
            }
        }
        return maximum;
    }

    //This method provides to find min element
    public double findMinimum() {
        BaseDataSet dataSet = realDataSet1;
        double minimum = dataSet.head.getValue();
        if (dataSet.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("DATASET IS EMPTY SO YOU DON'T GET MAX ELEMENT");
        } else {
            Element current = dataSet.head;

            while (current != null) {
                if (current.getValue() < minimum) {
                    minimum = current.getValue();
                }
                current = current.next;
            }
        }
        return minimum;
    }

    //This method provides to reverse dataset
    public double[] reverse() {
        double[] array2 = new double[24];
        if (realDataSet1.isEmpty()) {
            System.out.println("Data Set is empty so you don't get reverse any data");
        } else {
            Element current = realDataSet1.head;
            double[] array = new double[24];
            for (int i = 0; i < realDataSet1.size; i++) {
                array[i] = current.getValue();
                current = current.next;
            }
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[array.length - 1 - i];
                //   System.out.println(array[array.length - 1 - i]);
            }
        }
        return array2;
    }

    //This method provides to update element
    public void update(int index, double value) {
        if (realDataSet1.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("Data Set is empty so you don't update any data");
            alert.show();
        } else {
            Element current = realDataSet1.head;
            double[] array = new double[24];
            for (int i = 0; i < realDataSet1.size; i++) {
                array[i] = current.getValue();
                current = current.next;
            }
            if (index > realDataSet1.size) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setHeaderText(null);
                alert.setContentText("Element is not updated because your index greater than dataset size");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText(null);
                alert.setContentText("DATA SET IS UPDATED");
                alert.show();
                int i = 0;
                System.out.println("The updated array is : ");
                for (i = 0; i < index - 1; i++) {

                    System.out.println(array[i]);
                }
                array[i] = value;

                for (i = index - 1; i < array.length; i++) {

                    System.out.println(array[i]);
                }

            }

        }
    }

    //This method provides to delete dataset
    public boolean deleteAll() {

        if (!realDataSet1.isEmpty()) {
            realDataSet1.head = null;
            realDataSet1.tail = null;
            return true;
        }
        return false;
    }

    //This method provides to compare mse results
    public int resultOfMse() {
        ExponentialSmoothing exponentialSmoothing = new ExponentialSmoothing();
        DoubleExponentialSmoothing doubleExponentialSmoothing = new DoubleExponentialSmoothing();
        RegressionAnalysis regressionAnalysis = new RegressionAnalysis();
        DeseasonalizedRegressionAnalysis deseasonalizedRegressionAnalysis = new DeseasonalizedRegressionAnalysis();

        double array[] = {
                mse(exponentialSmoothing.exponentialSmoothing()),
                mse(doubleExponentialSmoothing.doubleExponentialSmoothing()),
                mse(regressionAnalysis.regressionAnalysis()),
                mse(deseasonalizedRegressionAnalysis.deseasonalizedRegressionAnalysis())
        };
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        if (min == mse(exponentialSmoothing.exponentialSmoothing())) {
            return 1;
        } else if (min == mse(doubleExponentialSmoothing.doubleExponentialSmoothing())) {
            return 2;
        } else if (min == mse(regressionAnalysis.regressionAnalysis())) {
            return 3;
        } else {
            return 4;
        }
    }
    /*public boolean selectDataSet(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("PLEASE SELECT THE DATASET YOU WANT TO DO PROCESS");
        ButtonType btnDataset1 = new ButtonType("DATASET1");
        ButtonType btnDataset2 = new ButtonType("DATASET2");
        alert.getButtonTypes().setAll(btnDataset1,btnDataset2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==btnDataset1){
            addData();
            return true;
        }
        else {
            addData2();
            return false;
        }
    }*/
}