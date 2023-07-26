package company.service;

import company.enums.Sex;
import company.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FinancialPenaltyServiceTest {

    private Company company;
    private Employee employee1;
    private Employee employee2;
    private FinancialPenalty financialPenalty1;
    private FinancialPenalty financialPenalty2;
    private FinancialPenaltyService financialPenaltyService;

    @Before
    public void init() {
        company = new Company("Januszex", LocalDate.of(2011, 7, 14));
        employee1 = new Manager("Adam", "Mark", 170, 60, LocalDate.of(1984, 12, 20), Sex.MALE);
        employee2 = new Developer("Marcin", "Janusz", 160, 32, LocalDate.of(1999, 3, 7), Sex.MALE);
        company.hireEmployee(employee1);
        company.hireEmployee(employee2);
        financialPenalty1 = new FinancialPenalty("Health and Safety",
                "Given when a company does not comply with the HaS rules", 300, company);
        financialPenalty2 = new FinancialPenalty("Bullying",
                "Given when boss bully each other", 200, company);
        financialPenaltyService = new FinancialPenaltyService();
    }


    @After
    public void clear() {
        Company.getExtension().clear();
        Employee.getExtension().clear();
    }

    @Test
    public void shouldReturnAmountOf2PenaltiesForCompany() {
        int testAmount = 2;
        int companyPenaltiesAmount = company.getFinancialPenalties().size();
        assertEquals(testAmount, companyPenaltiesAmount);
    }

    @Test
    public void shouldReturnCompanyPenaltiesAmountOf500() {
        double testAmount = 500;
        double wholePenaltiesAmount = financialPenaltyService.countPenaltiesAmount(company);
        assertEquals(testAmount, wholePenaltiesAmount, 0.00);
    }

    @Test
    public void shouldReturnPenaltyPerEmployeeAmountOf250() {
        double testAmount = 250;
        double penaltyPerEmployee = financialPenaltyService.countPenaltyPerEmployee(company);
        assertEquals(testAmount, penaltyPerEmployee, 0.00);
    }

}