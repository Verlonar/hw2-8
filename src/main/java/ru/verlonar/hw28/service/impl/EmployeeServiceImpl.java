package ru.verlonar.hw28.service.impl;

import org.springframework.stereotype.Service;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.exception.EmployeeIsAlreadyExistException;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = contains(firstName, lastName);
        if (newEmployee != null) {
            throw new EmployeeIsAlreadyExistException();
        } else {
            String fullName = firstName + " " + lastName;
            newEmployee = new Employee(firstName, lastName);
            employees.put(fullName, newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employeeToDelete = contains(firstName, lastName);
        if (employeeToDelete == null) {
            throw new EmployeeNotFoundException();
        } else {
            String fullName = firstName + " " + lastName;
            employees.remove(fullName);
            return employeeToDelete;
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeSoughtFor = contains(firstName, lastName);
        if (employeeSoughtFor == null) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeSoughtFor;
        }
    }

    @Override
    public Map<String, Employee> showAll() {
        return employees;
    }

    private Employee contains(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        return null;
    }
}
