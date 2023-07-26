package company.service;

import company.model.Car;
import company.model.Garage;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GarageServiceTest {

    private Garage g1;
    private Garage g2;
    private Garage g3;
    private Car c1;
    private GarageService garageService;
    private List<Garage> garages;

    @Before
    public void init() {
        garageService = new GarageService();
        g1 = new Garage("99A");
        g2 = new Garage("54B");
        g3 = new Garage("69X");
        c1 = new Car("OPEL", LocalDate.of(2000, 9, 5), LocalDate.of(2023, 12, 5));
        g1.parkCarInGarage(c1);
        garages = new ArrayList<>(List.of(g1, g2, g3));
    }

    @Test
    public void shouldReturnNullIfGarageIsEmpty() {
        assertNull(g2.getCarParked());
    }

    @Test
    public void shouldReturnAllGaragesWhereCarIsNull() {
        List<Garage> allEmptyGarages = garageService.findAllEmptyGarages(garages);
        assertEquals(List.of(g2, g3), allEmptyGarages);
    }

}