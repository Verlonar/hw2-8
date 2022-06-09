package ru.verlonar.hw28.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.data.EmployeeMap;
import ru.verlonar.hw28.exception.EmployeeIsAlreadyExistException;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.EmployeeService;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = EmployeeMap.getEmployees();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        firstName = modifyData(firstName);
        lastName = modifyData(lastName);
        Employee newEmployee = contains(firstName, lastName);
        if (newEmployee != null) {
            throw new EmployeeIsAlreadyExistException();
        } else {
            String fullName = firstName + " " + lastName;
            newEmployee = new Employee(firstName, lastName, department, salary);
            employees.put(fullName, newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        firstName = modifyData(firstName);
        lastName = modifyData(lastName);
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
        firstName = modifyData(firstName);
        lastName = modifyData(lastName);
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
        firstName = modifyData(firstName);
        lastName = modifyData(lastName);
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        return null;
    }

    private boolean checkUserData(String data) {
        boolean isOk;
        isOk = StringUtils.isNotBlank(data) && StringUtils.isAlpha(data);
        return isOk;
    }

    private String modifyData(String data) {
        data = StringUtils.lowerCase(data);
        data = StringUtils.deleteWhitespace(data);
        data = StringUtils.capitalize(data);
        if (!checkUserData(data)) {
            throw new EmployeeIsAlreadyExistException();
        }
        return data;
    }
}
