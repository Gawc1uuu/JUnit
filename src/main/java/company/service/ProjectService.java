package company.service;

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
}
