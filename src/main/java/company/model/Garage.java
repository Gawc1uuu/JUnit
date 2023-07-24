package company.model;

import company.exceptions.CarParkedInDifferentGarageException;
import company.exceptions.GarageFullException;

public class Garage {

    private String idOfGarage;

    private Car carParked;
    private Company company;

    public Garage(String idOfGarage) {
        this.idOfGarage = idOfGarage;
    }

    public void parkCarInGarage(Car car) {
        if (car == null) throw new IllegalArgumentException();
        if (carParked != null) throw new GarageFullException();
        if (car.getGarage() != null) throw new CarParkedInDifferentGarageException();
        carParked = car;
        car.setGarage(this);
    }

    public String getIdOfGarage() {
        return idOfGarage;
    }

    public void setIdOfGarage(String idOfGarage) {
        this.idOfGarage = idOfGarage;
    }

    public Car getCarParked() {
        return carParked;
    }

    public void setCarParked(Car carParked) {
        this.carParked = carParked;
    }
}
