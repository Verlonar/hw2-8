package ru.verlonar.hw28.service.impl;

import org.springframework.stereotype.Service;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.data.EmployeeMap;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.DepartmentService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    final Map<String, Employee> employees;

    public DepartmentServiceImpl() {
        this.employees = EmployeeMap.getEmployees();
    }

    @Override
    public Employee getMaximumWageEmployeeOfDepartment(int departmentId) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMinimumWageEmployeeOfDepartment(int departmentId) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeesFromDepartment(int departmentId) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesGroupByDepartments() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
