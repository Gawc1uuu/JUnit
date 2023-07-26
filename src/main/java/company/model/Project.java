package company.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;

    private Company company;
    private List<Developer> team = new ArrayList<>();
    private Manager manager;

    public Project(String name, Manager manager, Company company) {
        this.name = name;
        this.manager = manager;
        this.company = company;
        company.addProject(this);
    }

    public void addDeveloperToProject(Developer dev) {
        if (dev == null) throw new IllegalArgumentException();
        if (dev.getProjects() != null) throw new IllegalArgumentException();
        team.add(dev);
        dev.addProject(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getTeam() {
        return team;
    }

    public void setTeam(List<Developer> team) {
        this.team = team;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
