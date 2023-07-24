package company.model;

import company.enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private int hoursWorked;
    private double hourlyWage;
    private LocalDate birthDate;
    private Sex sex;
    private List<Company> companies = new ArrayList<>();
    private static List<Employee> extension = new ArrayList<>();

    public Employee(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.birthDate = birthDate;
        this.sex = sex;
        extension.add(this);
    }

    public static List<Employee> getExtension() {
        return extension;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return hourlyWage * hoursWorked;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return hoursWorked == employee.hoursWorked && Double.compare(employee.hourlyWage, hourlyWage) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(companies, employee.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, hoursWorked, hourlyWage, companies);
    }
}
