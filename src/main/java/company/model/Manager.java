package company.model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private Project project;

    public Manager(String firstName, String lastName, int hoursWorked, double hourlyWage) {
        super(firstName, lastName, hoursWorked, hourlyWage);
    }


}
