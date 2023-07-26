package company.model;

import company.enums.Sex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Developer developer;
    private Company c1;
    private Company c2;

    @Before
    public void init() {
        developer = new Developer("Robert", "Lewandowski", 100, 90, LocalDate.of(2000, 10, 1), Sex.MALE);
        c1 = new Company("Samsung", LocalDate.of(2007, 2, 9));
        c2 = new Company("Apple", LocalDate.of(1984, 11, 13));
        c1.hireEmployee(developer);
        c2.hireEmployee(developer);

    }

    @After
    public void cleanUp() {
        Employee.getExtension().clear();
        Company.getExtension().clear();
    }

    @Test
    public void shouldReturnEmployeeFirstNameRobert() {
        String employeeFirstName = developer.getFirstName();
        assertEquals("Robert", employeeFirstName);
    }

    @Test
    public void shouldReturnEmployeeSalaryEqualTo9000() {
        double employeeSalary = developer.getSalary();
        assertEquals(9000.0, employeeSalary, 0.1);
    }

    @Test
    public void shouldCheckIfEmployeeIsHiredBy2Companies() {
        int numOfCompanies = developer.getCompanies().size();
        assertEquals(2, numOfCompanies);
    }

    @Test
    public void shouldCheckIfSizeOfExtensionIs3() {
        Developer developer1 = new Developer("Sebastian", "Alvarez", 180, 50, LocalDate.of(1990, 12, 10), Sex.MALE);
        Developer developer2 = new Developer("Jan", "Kowalski", 170, 55, LocalDate.of(1998, 6, 4), Sex.MALE);
        int sizeOfExtension = Employee.getExtension().size();
        assertEquals(3, sizeOfExtension);
    }

}