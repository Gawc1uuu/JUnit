package company.service;

import company.model.Developer;
import company.model.Manager;
import company.model.Project;

import java.util.*;

////         metody projekty
//        znalezc projekt ktory ma najwiecej developerow
//        znalezc projekty danego Managera
public class ProjectService {
    public Project projectsWithMostDevelopers(List<Project> projects) {
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
