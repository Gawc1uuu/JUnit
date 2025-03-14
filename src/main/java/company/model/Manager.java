package company.model;

import company.enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private Project project;

    public Manager(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex) {
        super(firstName, lastName, hoursWorked, hourlyWage, birthDate, sex);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
