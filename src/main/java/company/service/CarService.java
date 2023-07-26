package company.service;

import company.model.Car;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CarService {

    public Car findOldestCar(List<Car> cars) {
        return Optional.ofNullable(cars)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .min(Comparator.comparing(car -> car.getProductionDate()))
                .orElse(null);
    }

    public Car findNewestCar(List<Car> cars) {
        return Optional.of(cars).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .max(Comparator.comparing(Car::getProductionDate))
                .orElse(null);
    }

    public List<Car> findAllCarsOfBrand(List<Car> cars, String producer) {
        return Optional.ofNullable(cars).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .filter(car -> car.getProducer().equals(producer))
                .toList();
    }

    public List<Car> findAllCarsThatHaveIncomingService(List<Car> cars) {
        return Optional.ofNullable(cars).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull).filter(car -> {
                    long daysDiff = ChronoUnit.DAYS.between(LocalDate.now(), car.getNextServiceDate());
                    return daysDiff < 30;
                }).toList();
    }

    public double findAverageAgeOfCars(List<Car> cars) {
        long sumOfAges = Optional.ofNullable(cars).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .map(car -> {
                    long carAge = ChronoUnit.YEARS.between(car.getProductionDate(), LocalDate.now());
                    return carAge;
                }).mapToLong(value -> value).sum();
        long numOfCars = Optional.ofNullable(cars).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull).count();
        return Math.ceil((double) sumOfAges / numOfCars);
    }


}
