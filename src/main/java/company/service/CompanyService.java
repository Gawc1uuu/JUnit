package company.service;

import company.model.Company;
import company.model.Developer;
import company.model.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CompanyService {

    public double countSalaryOfAllEmployees(List<Employee> employeeList) {
        return Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .collect(Collectors.summingDouble(Employee::getSalary));
    }

    public Company companyWithMostEmployees(List<Company> companies){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(company -> company.getEmployees().size()))
                .orElse(null);
    }

    public Company companyWithFewestEmployees(List<Company> companies){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(company -> company.getEmployees().size()))
                .orElse(null);
    }

    public Company companyWithTheHighestPayment(List<Company> companies) {
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .max(Comparator.comparing(company -> Optional.ofNullable(company.getEmployees())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .mapToDouble(Employee::getSalary)
                        .sum()))
                .orElse(null);
    }

    public Company companyWithTheLowestPayment(List<Company> companies) {
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(company -> Optional.ofNullable(company.getEmployees())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .mapToDouble(Employee::getSalary)
                        .sum()))
                .orElse(null);
    }

    public Company companyWithTheMostDevelopers(List<Company> companies) {
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(company -> Optional.ofNullable(company.getEmployees())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .map(employee -> employee instanceof Developer)
                        .count()))
                .orElse(null);
    }

    public Company oldestCompany(List<Company> companies){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Company::getCreateDate))
                .orElse(null);
    }

    public Company newestCompany(List<Company> companies){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Company::getCreateDate))
                .orElse(null);
    }

    public List<Company> companiesCreatedBetweenGivenDates(List<Company> companies, LocalDate from, LocalDate to){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(company -> {
                    LocalDate companyCreateDate = company.getCreateDate();
                    return (companyCreateDate.isEqual(from) || companyCreateDate.isAfter(from) &&
                            companyCreateDate.isBefore(to) || companyCreateDate.isEqual(to));
                })
                .toList();
    }

    public double averageCompanyAge(List<Company> companies){
        LocalDate today = LocalDate.now();
        double totalAge = Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToLong(company -> company.getCreateDate().until(today).getYears())
                .sum();

        return totalAge / companies.size();
    }

    public Company companyWithTheMostProject(List<Company> companies){
        return Optional.ofNullable(companies)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(company -> company.getProjects().size()))
                .orElse(null);
    }
}
