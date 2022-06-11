package ru.verlonar.hw28.service.impl;

import org.springframework.stereotype.Service;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.DepartmentService;
import ru.verlonar.hw28.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaximumWageEmployeeOfDepartment(int departmentId) {
        return employeeService.showAll().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMinimumWageEmployeeOfDepartment(int departmentId) {
        return employeeService.showAll().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeesFromDepartment(int departmentId) {
        if (employeeService.showAll().size() == 0) {
            throw new EmployeeNotFoundException();
        }

        List<Employee> result = employeeService.showAll().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.toList());
         if (result.size() == 0) {
             throw new EmployeeNotFoundException();
         }

         return result;
    }

    @Override
    public List<Employee> getEmployeesGroupByDepartments() {
        if (employeeService.showAll().size() == 0) {
            throw new EmployeeNotFoundException();
        }
        return employeeService.showAll().values().stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
