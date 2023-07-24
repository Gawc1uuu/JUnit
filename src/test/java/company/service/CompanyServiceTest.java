package company.service;

import company.enums.Sex;
import company.model.Company;
import company.model.Developer;
import company.model.Manager;
import company.model.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyServiceTest {

    private Company company1;
    private Company company2;
    private CompanyService companyService;
    private Project project1;
    private Project project2;
    private Project project3;
    private Developer d1;
    private Developer d2;
    private Developer d3;
    private Developer d4;

    @Before
    public void init() {
        company1 = new Company("Orlen", LocalDate.of(1998, 7, 18));
        company2 = new Company("Lotos", LocalDate.of(1994, 2, 17));
        companyService = new CompanyService();
        project1 = new Project("Nowa roksa",
                new Manager("Andrzej", "Walonko", 170, 70, LocalDate.of(1987, 2, 7), Sex.MALE),
                company1);
        project2 = new Project("Piec krematoryjny",
                new Manager("Max", "Stolczydło", 60, 45, LocalDate.of(1991, 1, 14), Sex.MALE),
                company2);
        project3 = new Project("Seksualna domina",
                new Manager("Olga", "Maniera", 214, 50, LocalDate.of(2000, 6, 5), Sex.FEMALE),
                company2);
        d1 = new Developer("Jan", "Kowalski", 1, 230, LocalDate.of(2000, 10, 1), Sex.MALE);
        d2 = new Developer("Maciej", "Nowak", 2, 30, LocalDate.of(2000, 10, 1), Sex.MALE);
        d3 = new Developer("Jan", "Kowalski", 1, 130, LocalDate.of(2000, 10, 1), Sex.MALE);
        d4 = new Developer("Jan", "Kowalski", 1, 330, LocalDate.of(2000, 10, 1), Sex.MALE);
        company1.hireEmployee(d1);
        company1.hireEmployee(d2);
        company1.hireEmployee(d3);
        company1.hireEmployee(d4);
        company2.hireEmployee(d1);
        company2.hireEmployee(d2);
    }

    @After
    public void clearExtension(){
        Company.getExtension().clear();
    }

    @Test
    public void shouldCheckIfSalaryPaidToAllEmployeesIsCorrect() {
        double employeesSalarySum = companyService.countSalaryOfAllEmployees(company1.getEmployees());
        assertEquals(750.0, employeesSalarySum, 0.1);
    }

    @Test
    public void shouldReturnCompanyWithTheMostEmployeesThatIsCompany1(){
        Company testCompany = company1;
        Company companyWithMostEmployees = companyService.companyWithMostEmployees(Company.getExtension());
        assertEquals(testCompany, companyWithMostEmployees);
    }

    @Test
    public void shouldReturnCompanyWithTheFewestEmployeesThatIsCompany2(){
        Company testCompany = company2;
        Company companyWithFewestEmployees = companyService.companyWithFewestEmployees(Company.getExtension());
        assertEquals(testCompany, companyWithFewestEmployees);
    }

    @Test
    public void shouldReturnCompanyWithTheHighestPaymentThatIsCompany1(){
        Company testCompany = company1;
        Company companyWithHighestPayment = companyService.companyWithTheHighestPayment(Company.getExtension());
        assertEquals(testCompany, companyWithHighestPayment);
    }

    @Test
    public void shouldReturnCompanyWithTheLowestPaymentThatIsCompany2(){
        Company testCompany = company2;
        Company companyWithLowestPayment = companyService.companyWithTheLowestPayment(Company.getExtension());
        assertEquals(testCompany, companyWithLowestPayment);
    }

    @Test
    public void shouldReturnCompanyWithTheMostDevelopersThatIsCompany1(){
        Company testCompany = company1;
        Company companyWithTheMostDevelopers = companyService.companyWithTheMostDevelopers(Company.getExtension());
        assertEquals(testCompany, companyWithTheMostDevelopers);
    }

    @Test
    public void shouldReturnTheOldestCompanyThatIsCompany2(){
        Company testCompany = company2;
        Company oldestCompany = companyService.oldestCompany(Company.getExtension());
        assertEquals(testCompany, oldestCompany);
    }

    @Test
    public void shouldReturnTheNewestCompanyThatIsCompany1(){
        Company testCompany = company1;
        Company newestCompany = companyService.newestCompany(Company.getExtension());
        assertEquals(testCompany, newestCompany);
    }

    @Test
    public void shouldReturnCompanieThatWereCreatedBetweenGivenAgeThatIsListWithCompany2(){
        List<Company> testCompanyList = List.of(company2);
        List<Company> companiesCreatedBetweenAge = companyService.companiesCreatedBetweenGivenDates(
                Company.getExtension(), LocalDate.of(1993, 4, 6), LocalDate.of(1995, 6, 8));
        assertEquals(testCompanyList, companiesCreatedBetweenAge);
    }

    @Test
    public void shouldReturnAverageCompanyAgeThatIs27(){
        double testAge = 27;
        double averageCompanyAge = companyService.averageCompanyAge(Company.getExtension());
        assertEquals(testAge, averageCompanyAge, 0.00);
    }

    @Test
    public void shouldReturnCompanyWithTheMostProjectsThatIsCompany2(){
        Company testCompany = company2;
        Company companyWithMostProjects = companyService.companyWithTheMostProject(Company.getExtension());
        assertEquals(testCompany, companyWithMostProjects);
    }
}