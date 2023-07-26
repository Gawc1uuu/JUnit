package company.service;

import company.model.Car;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarServiceTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;
    private CarService carService;
    private List<Car> carList;

    @Before
    public void init() {
        car1 = new Car("BMW", LocalDate.of(2022, 6, 1), LocalDate.of(2023, 7, 30));
        car2 = new Car("BMW", LocalDate.of(2020, 10, 15), LocalDate.of(2024, 12, 5));
        car3 = new Car("TOYOTA", LocalDate.of(2019, 1, 10), LocalDate.of(2023, 8, 2));
        car4 = new Car("MAZDA", LocalDate.of(2004, 9, 16), LocalDate.of(2023, 11, 3));
        carService = new CarService();
        carList = new ArrayList<>(List.of(car1, car2, car3, car4));
    }

    @Test
    public void shouldReturnOldestCar() {
        Car oldest = carService.findOldestCar(carList);
        assertEquals(car4, oldest);
    }

    @Test
    public void shouldReturnNewestCar() {
        Car newest = carService.findNewestCar(carList);
        assertEquals(car1, newest);
    }

    @Test
    public void shouldReturnListOfAllBMWs() {
        List<Car> bmws = carService.findAllCarsOfBrand(carList, "BMW");
        assertEquals(List.of(car1, car2), bmws);
    }

    @Test
    public void shouldReturnCarsThatHaveServiceInLessThan30Days() {
        List<Car> serviceCars = carService.findAllCarsThatHaveIncomingService(carList, 30);
        assertEquals(List.of(car1, car3), serviceCars);
    }

    @Test
    public void shouldReturnAverageAgeOfAllCarsInYears() {
        double avgAge = carService.findAverageAgeOfCars(carList);
        assertEquals(7.0, avgAge, 0.1);
    }

}