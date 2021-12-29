package com.company.model;

public class Element {

    private double value;
    Element next;
    Element previous;

    //Constructor
    public Element(double value){
        this.value = value;
        this.next=null;
        this.previous=null;
    }

    //Getter method
    public double getValue(){
        return this.value;
    }


}