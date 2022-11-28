package com.company.dao;

import com.company.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class jdbcCarDao implements CarDao {

    private final JdbcTemplate jdbcTemplate;

    public jdbcCarDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Car> getCarsByMake(String make) {

        List<Car> cars = new ArrayList<>();
        String sqlCommand = "SELECT * FROM car WHERE make = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCommand, make);
        while (results.next()){
            cars.add(mapRowToCar(results));
        }

        return cars;
    }

    @Override
    public Car getCarByModel() {
        return null;
    }

    @Override
    public void addCar() {

    }

    @Override
    public void updateCar() {

    }

    @Override
    public void deleteCar() {

    }

    private Car mapRowToCar(SqlRowSet rowSet) {
        Car car = new Car();
        car.setMake(rowSet.getString("make"));
        car.setModel(rowSet.getString("model"));
        car.setTopSpeed(rowSet.getInt("top_speed"));
        car.setZeroTo60(rowSet.getDouble("zero_to_60"));
        return car;
    }


}
