package company.service;

import company.enums.Sex;
import company.exceptions.NoEnoughEmployeesException;
import company.model.Company;
import company.model.Developer;
import company.model.Employee;
import company.model.Manager;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {
    private Developer developer;
    private Developer developer1;
    private Developer developer2;
    private Developer developer3;
    private Manager manager;
    private Manager manager1;
    private Company c1;
    private Company c2;
    List<Employee> employees;
    @Before
    public void init(){
        developer = new Developer("Robin", "Hood", 80, 80, LocalDate.of(1995,3, 15), Sex.MALE);
        developer1 = new Developer("Meggie", "Doe", 85, 85, LocalDate.of(1993,7, 24), Sex.FEMALE);
        developer2 = new Developer("Martha", "Brown", 90, 90, LocalDate.of(1999,9, 1), Sex.FEMALE);
        developer3 = new Developer("Arnold", "Smith", 95, 95, LocalDate.of(1997,2, 28), Sex.MALE);
        manager = new Manager("Roberta", "Johannsen", 100, 100, LocalDate.of(1990, 12, 3), Sex.FEMALE);
        manager1 = new Manager("Kristin", "Nilsen", 110, 105, LocalDate.of(2000, 1, 7), Sex.FEMALE);
        c1 = new Company("Samsung", LocalDate.of(2007, 2, 9));
        c2 = new Company("Apple", LocalDate.of(1984, 11, 13));
        c1.hireEmployee(developer);
        c1.hireEmployee(developer1);
        c1.hireEmployee(developer2);
        c1.hireEmployee(manager);
        c2.hireEmployee(developer1);
        c2.hireEmployee(developer3);
        c2.hireEmployee(manager1);
        employees = Arrays.asList(developer, developer1, developer2, developer3, manager, manager1);
    }
    @Test
    public void shouldReturnBestPaidWorkers() {
        List<Employee> result = EmployeeService.returnBestPaidWorkers(employees);
      assertEquals(1, result.size());
        assertEquals(manager1, result.get(0));
    }
@Test
    public void shouldReturnTopNBestPaidWorkers (){
       List<Employee> result = EmployeeService.returnTopNBestPaidWorkers(employees, 2);
        assertEquals(2, result.size());
        assertEquals(manager1, result.get(0));
        assertEquals(manager, result.get(1));
}
@Test (expected = NoEnoughEmployeesException.class)
    public void shouldReturnNoEnoughEmployeesExceptionWhenParametherNumberIsBiggerThanListSize(){
EmployeeService.returnTopNBestPaidWorkers(employees, 7);
}

@Test
    public void shouldSortEmployeesByTheirSalaries(){
    List<Employee> result = EmployeeService.sortEmployeesBySalary(employees);
    assertEquals(6, result.size());
    assertEquals(developer, result.get(0));
    assertEquals(developer1, result.get(1));
    assertEquals(developer2, result.get(2));
    assertEquals(developer3, result.get(3));
    assertEquals(manager, result.get(4));
    assertEquals(manager1, result.get(5));
}
@Test
    public void shouldReturnTheWorstPaidEmployees(){
        List<Employee> result = EmployeeService.findTheWorstPaidEmployees(employees, 2);
        assertEquals(2, result.size());
        assertEquals(developer, result.get(0));
        assertEquals(developer1, result.get(1));
}
@Test
    public void shouldReturnAverageSalary(){
        double expectedSalary = EmployeeService.findAverageSalary(employees);
assertEquals(8716.67, expectedSalary, 1);
    }
    @Test
    public void shouldReturnTheOldestEmployee(){
        Employee theOldest = EmployeeService.findTheOldestEmployee(employees);
        assertEquals(manager, theOldest);
    }
    @Test
    public void shouldReturnTheYoungestEmployee(){
        Employee theYoungest = EmployeeService.findTheYoungestEmployee(employees);
        assertEquals(manager1, theYoungest);
    }
    @Test
    public void shouldReturnAverageAgeOfEmployees(){
        double expectedAverageAge = EmployeeService.returnAverageAgeOfEmployees(employees);
        assertEquals(27, expectedAverageAge, 1);
    }
    @Test
    public void shouldReturnWomanAsMostPopularSexWithinEmployees(){
        String expectedSex = EmployeeService.returnThMostPopularSexWithinTheEmployees(employees);
        assertEquals(Sex.FEMALE.toString(), expectedSex);
    }
}