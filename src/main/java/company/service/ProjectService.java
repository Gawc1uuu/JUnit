package company.service;

import company.model.Developer;
import company.model.Manager;
import company.model.Project;

import java.util.*;

public class ProjectService {
    public Project projectWithMostDevelopers(List<Project> projects) {
        return Optional.ofNullable(projects)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(project -> project.getTeam().size()))
                .orElse(null);
    }

    public List<Project> projectsWithManager(List<Project> projects, Manager manager) {
        return Optional.ofNullable(projects)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(project -> project.getManager().equals(manager))
                .toList();
    }

    public List<Project> projectsContainsName(List<Project> projects, String name) {
        return Optional.ofNullable(projects)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(project -> project.getName().contains(name))
                .toList();
    }

    public List<Project> projectsWithDeveloper(List<Project> projects, Developer developer) {
        return Optional.ofNullable(projects)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(project -> project.getTeam().contains(developer))
                .toList();
    }
}
