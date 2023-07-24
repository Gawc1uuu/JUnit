package company.model;

public class Developer extends Employee {

    private Project project;

    public Developer(String firstName, String lastName, int hoursWorked, double hourlyWage) {
        super(firstName, lastName, hoursWorked, hourlyWage);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
