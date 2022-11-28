package com.company.model;

public class Car {

    private String make;
    private String model;
    private int topSpeed;
    private double zeroTo60;

    public Car(){

    }

    public String getMake(){
        return make;
    }

    public void setMake(String make){
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getZeroTo60() {
        return zeroTo60;
    }

    public void setZeroTo60(double zeroTo60) {
        this.zeroTo60 = zeroTo60;
    }

}
