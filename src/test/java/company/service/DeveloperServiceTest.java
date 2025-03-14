package company.service;

import company.enums.ProgramingLanguage;
import company.enums.Sex;
import company.model.Company;
import company.model.Developer;
import company.model.Manager;
import company.model.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeveloperServiceTest {

    private Developer d1;
    private Developer d2;
    private Developer d3;
    private Developer d4;
    private Developer d5;
    private List<Developer> developerList;

    private DeveloperService developerService;

    private Company c1;
    private Company c2;
    private Company c3;

    private Manager m1;

    private Project p1;
    private Project p2;
    private Project p3;
    private Project p4;

    @Before
    public void init() {
        developerService = new DeveloperService();

        d1 = new Developer("Jan", "Nowak", 200, 100, LocalDate.of(1990, 12, 9), Sex.MALE);
        d2 = new Developer("Adam", "Polak", 168, 80, LocalDate.of(1980, 11, 1), Sex.MALE);
        d3 = new Developer("Maria", "Zdrowa", 150, 250, LocalDate.of(1975, 1, 12), Sex.FEMALE);
        d4 = new Developer("Anna", "Madra", 180, 140, LocalDate.of(1992, 6, 9), Sex.FEMALE);
        d5 = new Developer("Tomek", "Domek", 45, 20, LocalDate.of(1952, 3, 25), Sex.MALE);
        developerList = Arrays.asList(d1, d2, d3, d4, d5);

        d1.addProgrammingLanguage(ProgramingLanguage.C);
        d2.addProgrammingLanguage(ProgramingLanguage.JAVA);
        d2.addProgrammingLanguage(ProgramingLanguage.JAVASCRIPT);
        d2.addProgrammingLanguage(ProgramingLanguage.CPLUSPLUS);
        d2.addProgrammingLanguage(ProgramingLanguage.GROOVY);
        d3.addProgrammingLanguage(ProgramingLanguage.C);
        d4.addProgrammingLanguage(ProgramingLanguage.JAVA);
        d4.addProgrammingLanguage(ProgramingLanguage.JAVASCRIPT);
        d4.addProgrammingLanguage(ProgramingLanguage.PYTHON);
        d5.addProgrammingLanguage(ProgramingLanguage.JAVASCRIPT);

        c1 = new Company("Good company", LocalDate.now());
        c2 = new Company("Average company", LocalDate.now());
        c3 = new Company("Bad company", LocalDate.now());

        m1 = new Manager("Monika", "Managerska", 180, 50, LocalDate.of(1997, 7, 1), Sex.FEMALE);

        p1 = new Project("P1", m1, c1);
        p2 = new Project("P2", m1, c1);
        p3 = new Project("P3", m1, c2);
        p4 = new Project("P4", m1, c3);

        p1.addDeveloperToProject(d1);
        p1.addDeveloperToProject(d2);
        p2.addDeveloperToProject(d1);
        p3.addDeveloperToProject(d1);
        p3.addDeveloperToProject(d3);
        p4.addDeveloperToProject(d4);
        p4.addDeveloperToProject(d2);
    }

    @After
    public void clean() {
        Developer.getExtension().clear();
        Manager.getExtension().clear();
        Company.getExtension().clear();
    }

    @Test
    public void shouldReturnListContaining6DevelopersForGetDevelopersExtension() {
        assertEquals(6, Developer.getExtension().size());
    }

    @Test
    public void shouldReturnListOfDevelopersWhichWorksForMoreThan1Company() {
        List<Developer> devsWithMoreThanOneCompanyList = Arrays.asList(d1, d2);
        assertEquals(devsWithMoreThanOneCompanyList, developerService.developerWorksInMoreThanCompanies(developerList, 1));
    }

    @Test
    public void shouldReturnDeveloperWithMostProjects() {
        assertEquals(d1, developerService.developerWithMostProjects(developerList));
    }

    @Test
    public void shouldReturnDevelopersWhichKnowsC() {
        List<Developer> devsKnowsC = Arrays.asList(d1, d3);
        assertEquals(devsKnowsC, developerService.developersWithProgrammingLanguage(developerList, ProgramingLanguage.C));
    }

    @Test
    public void shouldReturnEmptyListForDevelopersWhichKnowsCSharp() {
        assertEquals(Arrays.asList(), developerService.developersWithProgrammingLanguage(developerList, ProgramingLanguage.CSHARP));
    }

    @Test
    public void shouldReturnEmptyListForDevelopersWhichKnowsCSharpForNullListOfDevelopers() {
        assertEquals(Arrays.asList(), developerService.developersWithProgrammingLanguage(null, ProgramingLanguage.CSHARP));
    }

    @Test
    public void shouldReturnDevelopersWhichKnowsJavaAndJavaScript() {
        List<Developer> devsWithJavaAndJavaScript = Arrays.asList(d2, d4);
        List<ProgramingLanguage> languages = Arrays.asList(ProgramingLanguage.JAVASCRIPT, ProgramingLanguage.JAVA);
        assertEquals(devsWithJavaAndJavaScript, developerService.developerWithProgrammingLanguages(developerList, languages));
    }

    @Test
    public void shouldReturnDeveloperWithMostProgrammingLanguages() {
        assertEquals(d2, developerService.developerWithMostProgrammingLanguages(developerList));
    }
}
