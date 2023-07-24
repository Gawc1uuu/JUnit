package company.service;

import company.enums.Sex;
import company.model.Company;
import company.model.Developer;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CompanyServiceTest {

    private Company company;
    private CompanyService companyService;
    private Developer d1;
    private Developer d2;
    private Developer d3;
    private Developer d4;

    @Before
    public void init() {
        company = new Company("Orlen", LocalDate.of(1998, 7, 18));
        companyService = new CompanyService();
        d1 = new Developer("Jan", "Kowalski", 1, 230, LocalDate.of(2000, 10, 1), Sex.MALE);
        d2 = new Developer("Maciej", "Nowak", 2, 30, LocalDate.of(2000, 10, 1), Sex.MALE);
        d3 = new Developer("Jan", "Kowalski", 1, 130, LocalDate.of(2000, 10, 1), Sex.MALE);
        d4 = new Developer("Jan", "Kowalski", 1, 330, LocalDate.of(2000, 10, 1), Sex.MALE);
        company.hireEmployee(d1);
        company.hireEmployee(d2);
        company.hireEmployee(d3);
        company.hireEmployee(d4);
    }

    @Test
    public void shouldCheckIfSalaryPaidToAllEmployeesIsCorrect() {
        double employeesSalarySum = companyService.countSalaryOfAllEmployees(company.getEmployees());
        assertEquals(750.0, employeesSalarySum, 0.1);
    }

}