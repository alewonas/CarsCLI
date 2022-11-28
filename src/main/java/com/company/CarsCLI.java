package com.company;

import com.company.dao.CarDao;
import com.company.dao.jdbcCarDao;
import com.company.model.Car;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class CarsCLI {

    private final CarDao carDao;
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cars");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        CarsCLI application = new CarsCLI(dataSource);
        application.runMenu();
    }

    public CarsCLI(DataSource dataSource) {
        carDao = new jdbcCarDao(dataSource);

    }

    public void runMenu() {
        displayIntro();
        boolean isMenuRunning = true;
        while (isMenuRunning) {
            displayMainMenu();
            int userSelection = Integer.parseInt(userInput.nextLine());
            if (userSelection == 1) {
                searchByMake();

            }

        }

    }

    public void displayIntro() {
        System.out.println("-----------------------------------------");
        System.out.println("|              Cars Database            |");
        System.out.println("-----------------------------------------");
    }

    public void displayMainMenu() {

        System.out.println("1. Search for car(s) by make");
        System.out.println("2. Search for a car by model");
        System.out.println("3. Add a car to the database");
        System.out.println("4. Update a car in the database");
        System.out.println("5. Delete a car from the database");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Please enter an option number: ");

    }

    public void searchByMake() {
        System.out.println();
        System.out.print("Please enter the make you would like to search: ");
        String makeChoice = userInput.nextLine();
        List<Car> cars = carDao.getCarsByMake(makeChoice);

        for (Car car : cars) {
            System.out.println();
            System.out.println(car.getMake() + " " + car.getModel() + ":");
            System.out.println("Top Speed: " + car.getTopSpeed() + "mph | 0-60: " + car.getZeroTo60() + "secs");
            System.out.println();
        }

        if (cars.size() == 0) {
            System.out.println("No data on this make yet. You may add a new make and model from the home screen");
        }

    }
}
