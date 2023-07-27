package company.model;

import company.enums.ProgramingLanguage;
import company.enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Developer extends Employee {

    private List<Project> projects = new ArrayList<>();
    private Set<ProgramingLanguage> programingLanguages = new HashSet<>();

    public Developer(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex) {
        super(firstName, lastName, hoursWorked, hourlyWage, birthDate, sex);
    }

    public Developer(String firstName, String lastName, int hoursWorked, double hourlyWage, LocalDate birthDate, Sex sex, ProgramingLanguage programingLanguage) {
        super(firstName, lastName, hoursWorked, hourlyWage, birthDate, sex);
        this.programingLanguages.add(programingLanguage);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public Set<ProgramingLanguage> getProgramingLanguages() {
        return programingLanguages;
    }

    public void addProgrammingLanguage(ProgramingLanguage programingLanguage) {
        this.programingLanguages.add(programingLanguage);
    }
}
