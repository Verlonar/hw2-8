package ru.verlonar.hw28.data;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMap {

    private static final Map<String, Employee> EMPLOYEES = new HashMap<>();

    public static Map<String, Employee> getEmployees() {
        return EMPLOYEES;
    }
}
