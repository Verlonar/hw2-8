package ru.verlonar.hw28.service;

import org.springframework.stereotype.Service;
import ru.verlonar.hw28.data.Employee;

import java.util.List;

@Service
public interface DepartmentService {

    Employee getMaximumWageEmployeeOfDepartment(int departmentId);

    Employee getMinimumWageEmployeeOfDepartment(int departmentId);

    List<Employee> getAllEmployeesFromDepartment(int departmentId);

    List<Employee> getEmployeesGroupByDepartments();
}
