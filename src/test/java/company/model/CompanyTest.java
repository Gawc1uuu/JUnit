package company.model;

import company.enums.Sex;
import company.service.CompanyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CompanyTest {

    private Company company;
    private CompanyService companyService;
    private Developer d1;
    private Developer d2;
    private Developer d3;
    private Developer d4;

    @Before
    public void init() {
        company = new Company("Orlen", LocalDate.of(2001, 5, 16));
        companyService = new CompanyService();
        d1 = new Developer("Jan", "Kowalski", 150, 230, LocalDate.of(2000, 10, 1), Sex.MALE);
        d2 = new Developer("Maciej", "Nowak", 160, 30, LocalDate.of(1980, 4, 3), Sex.MALE);
        d3 = new Developer("Jan", "Kowalski", 120, 130, LocalDate.of(2001, 2, 15), Sex.MALE);
        d4 = new Developer("Jan", "Kowalski", 170, 330, LocalDate.of(1999, 11, 6), Sex.MALE);
        company.hireEmployee(d1);
        company.hireEmployee(d2);
        company.hireEmployee(d3);
        company.hireEmployee(d4);
    }

    @After
    public void cleanUp() {
        Developer.getExtension().clear();
        Company.getExtension().clear();
    }

    @Test
    public void shouldReturnTrueIfLengthOfCompanyNameIsCorrect() {
        int companyNameLength = company.getName().length();
        assertTrue(companyNameLength == 5);
    }

    @Test
    public void shouldCheckIfCompanyHires4Employees() {
        int numberOfEmployees = company.getEmployees().size();
        assertEquals(4, numberOfEmployees);
    }

    @Test
    public void shouldReturnNumberOfExtensionEqualTo1() {
        int numberOfInstances = Company.getExtension().size();
        assertEquals(1, numberOfInstances);
    }


}