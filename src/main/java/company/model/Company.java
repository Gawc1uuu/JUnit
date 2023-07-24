package company.model;


import company.exceptions.CarNotForSaleException;
import company.exceptions.EmployeeAlreadyHiredException;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;

    private List<Employee> employees = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();
    private List<Garage> garages = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    private static List<Company> extension = new ArrayList<>();

    public Company(String name) {
        this.name = name;
        extension.add(this);
    }

    public void buyNewCar(Car car) {
        if (car == null) throw new IllegalArgumentException();
        if (car.getCompany() != null) throw new CarNotForSaleException();
        cars.add(car);
        car.setCompany(this);
    }

    public void hireEmployee(Employee employee) {
        if (employees.contains(employee)) throw new EmployeeAlreadyHiredException();
        employees.add(employee);
        if (employee.getCompanies().contains(this))
            throw new EmployeeAlreadyHiredException("Already working for this company");
        employee.getCompanies().add(this);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public static List<Company> getExtension() {
        return extension;
    }

    public static void setExtension(List<Company> extension) {
        Company.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
