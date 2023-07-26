package company.service;

import company.model.Developer;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperService {
    public Developer developerWithMostProjects(List<Developer> developers) {
        return Optional.ofNullable(developers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(developer -> developer.getProjects().size()))
                .orElse(null);
    }

    public List<Developer> developerWorksInMoreThanCompanies(List<Developer> developers, int noOfProjects) {
        return Optional.ofNullable(developers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(developer -> developer.getProjects().size() > noOfProjects)
                .collect(Collectors.toList());
    }

}
