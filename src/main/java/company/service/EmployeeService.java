package company.service;

import company.enums.Sex;
import company.exceptions.NoEnoughEmployeesException;
import company.model.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    public static List<Employee> returnBestPaidWorkers(List<Employee> employees) {
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
        return employees.stream()
                .filter(e -> e.getSalary() == maxSalary)
                .collect(Collectors.toList());
    }


    public static List<Employee> returnTopNBestPaidWorkers(List<Employee> employees, int n) {
        if (n > employees.size()) throw new NoEnoughEmployeesException();
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static List<Employee> findTheWorstPaidEmployees(List<Employee> employees, int n) {
        if (n > employees.size()) throw new NoEnoughEmployeesException();
        return sortEmployeesBySalary(employees)
                .stream().limit(n)
                .collect(Collectors.toList());
    }

    public static double findAverageSalary(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public static Employee findTheOldestEmployee(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getBirthDate))
                .orElseThrow();
    }

    public static Employee findTheYoungestEmployee(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getBirthDate))
                .orElseThrow();
    }

    public static double returnAverageAgeOfEmployees(List<Employee> employees) {
        return Optional.ofNullable(employees)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(employee -> Period.between(employee.getBirthDate(), LocalDate.now()).getYears())
                .mapToLong(Long::valueOf)
                .average()
                .orElse(0.0);
    }

    public static String returnThMostPopularSexWithinTheEmployees(List<Employee> employees) {
        long numberOfWoman = employees.stream()
                .filter(employee -> employee.getSex() == Sex.FEMALE)
                .count();
        long numberOfMan = employees.stream()
                .filter(employee -> employee.getSex() == Sex.MALE)
                .count();
        if (numberOfWoman > numberOfMan) {
            return Sex.FEMALE.toString();
        } else if (numberOfMan > numberOfWoman) {
            return Sex.MALE.toString();
        } else {
            return "Equal number of man and woman";
        }
    }

}
