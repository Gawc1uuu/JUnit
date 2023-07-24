package company.service;

import company.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompanyService {

    public double countSalaryOfAllEmployees(List<Employee> employeeList) {
        return Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .collect(Collectors.summingDouble(Employee::getSalary));
    }

}
