package company.service;

import company.model.Company;
import company.model.FinancialPenalty;

public class FinancialPenaltyService {

    public double countPenaltiesAmount(Company company) {
        double wholeAmount = 0;
        for (FinancialPenalty penalty : company.getFinancialPenalties()) {
            wholeAmount += penalty.getAmount();
        }
        return wholeAmount;
    }


    public double countPenaltyPerEmployee(Company company) {
        int numberOfEmployees = company.getEmployees().size();
        double wholePenaltiesAmount = countPenaltiesAmount(company);
        return wholePenaltiesAmount / numberOfEmployees;
    }

}
