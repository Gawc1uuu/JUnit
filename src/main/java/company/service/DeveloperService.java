package company.service;

import company.enums.ProgramingLanguage;
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
                .filter(Objects::nonNull)
                .filter(developer -> developer.getProjects().size() > noOfProjects)
                .collect(Collectors.toList());
    }

    public List<Developer> developersWithProgrammingLanguage(List<Developer> developers, ProgramingLanguage pL) {
        return Optional.ofNullable(developers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(developer -> developer.getProgramingLanguages().contains(pL))
                .collect(Collectors.toList());
    }

    public List<Developer> developerWithProgrammingLanguages(List<Developer> developers, List<ProgramingLanguage> pL) {
        return Optional.ofNullable(developers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(developer -> developer.getProgramingLanguages().containsAll(pL))
                .collect(Collectors.toList());
    }

    public Developer developerWithMostProgrammingLanguages(List<Developer> developers) {
        return Optional.ofNullable(developers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(developer -> developer.getProgramingLanguages().size()))
                .orElse(null);
    }

}
