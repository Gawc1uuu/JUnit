package company.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Developer developer;
    private Company c1;
    private Company c2;

    @Before
    public void init() {
        developer = new Developer("Robert", "Lewandowski", 100, 90);
        c1 = new Company("Samsung");
        c2 = new Company("Apple");
        c1.hireEmployee(developer);
        c2.hireEmployee(developer);

    }

    @After
    public void cleanUp() {
        Employee.getExtension().clear();
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
        Developer developer1 = new Developer("Sebastian", "Alvarez", 180, 50);
        Developer developer2 = new Developer("Jan", "Kowalski", 170, 55);
        int sizeOfExtension = Employee.getExtension().size();
        assertEquals(3, sizeOfExtension);
    }

}