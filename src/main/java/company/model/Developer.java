package company.model;

import company.enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<Project> projects = new ArrayList<>();

    public Developer(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex) {
        super(firstName, lastName, hoursWorked, hourlyWage, birthDate, sex);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
