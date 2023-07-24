package company.model;

import company.enums.Sex;

import java.time.LocalDate;

public class Developer extends Employee {

    private Project project;

    public Developer(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex) {
        super(firstName, lastName, hoursWorked, hourlyWage, birthDate, sex);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
