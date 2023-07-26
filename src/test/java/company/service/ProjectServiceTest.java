package company.service;

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

public class ProjectServiceTest {

    private ProjectService projectService;
    private Project p1;
    private Project p2;
    private Project p3;
    private Project p4;
    private List<Project> projectList;

    private Company c1;
    private Company c2;
    private Company c3;

    private Manager m1;
    private Manager m2;

    private Developer d1;
    private Developer d2;
    private Developer d3;
    private Developer d4;

    @Before
    public void init() {
        projectService = new ProjectService();

        c1 = new Company("Good company", LocalDate.now());
        c2 = new Company("Average company", LocalDate.now());
        c3 = new Company("Bad company", LocalDate.now());

        m1 = new Manager("Monika", "Managerska", 180, 50, LocalDate.of(1997, 7, 1), Sex.FEMALE);
        m2 = new Manager("Andrzej", "Meczydupa", 20, 40, LocalDate.of(1950, 4, 3), Sex.MALE);

        p1 = new Project("P1", m1, c1);
        p2 = new Project("P2", m1, c1);
        p3 = new Project("P3", m1, c2);
        p4 = new Project("P4", m2, c3);

        projectList = Arrays.asList(p1, p2, p3, p4);

        d1 = new Developer("Jan", "Nowak", 200, 100, LocalDate.of(1990, 12, 9), Sex.MALE);
        d2 = new Developer("Adam", "Polak", 168, 80, LocalDate.of(1980, 11, 1), Sex.MALE);
        d3 = new Developer("Maria", "Zdrowa", 150, 250, LocalDate.of(1975, 1, 12), Sex.FEMALE);
        d4 = new Developer("Anna", "Madra", 180, 140, LocalDate.of(1992, 6, 9), Sex.FEMALE);

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
        Company.getExtension().clear();
        Manager.getExtension().clear();
    }


    @Test
    public void shouldReturnProjectWithMostDevelopersP1() {
        assertEquals(p1, projectService.projectWithMostDevelopers(projectList));
    }

    @Test
    public void shouldReturnProjectWithManagerM1() {
        List<Project> projectsWithManagerM1 = Arrays.asList(p1, p2, p3);
        assertEquals(projectsWithManagerM1, projectService.projectsWithManager(projectList, m1));
    }
}
