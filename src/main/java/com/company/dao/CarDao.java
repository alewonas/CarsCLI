package com.company.dao;

import com.company.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> getCarsByMake(String make);

    public Car getCarByModel();

    public void addCar();

    public void updateCar();

    public void deleteCar();
}
