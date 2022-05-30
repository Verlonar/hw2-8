package ru.verlonar.hw28.service;

import ru.verlonar.hw28.data.Employee;

import java.util.List;

public interface DepartmentService {

    Employee getMaximumWageEmployeeOfDepartment(int departmentId);

    Employee getMinimumWageEmployeeOfDepartment(int departmentId);

    List<Employee> getAllEmployeesFromDepartment(int departmentId);

    List<Employee> getEmployeesGroupByDepartments();
}
