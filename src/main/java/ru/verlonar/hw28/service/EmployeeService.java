package ru.verlonar.hw28.service;

import ru.verlonar.hw28.data.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> showAll();
}
