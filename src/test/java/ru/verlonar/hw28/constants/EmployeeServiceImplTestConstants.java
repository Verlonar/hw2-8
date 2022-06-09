package ru.verlonar.hw28.constants;

import ru.verlonar.hw28.data.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImplTestConstants {

    public static final String JOHN_FIRST_NAME = "John";
    public static final String JOHN_LAST_NAME = "Snow";
    public static final int JOHN_DEPARTMENT = 0;
    public static final double JOHN_SALARY = 9.47;

    public static final Employee JOHN_EMPLOYEE = new Employee(JOHN_FIRST_NAME, JOHN_LAST_NAME, JOHN_DEPARTMENT, JOHN_SALARY);

    public static final String FILL_FIRST_NAME = "Fill";
    public static final String FILL_LAST_NAME = "Spenser";
    public static final int FILL_DEPARTMENT = 1;
    public static final double FILL_SALARY = 999_069.84;

    public static final Employee FILL_EMPLOYEE = new Employee(FILL_FIRST_NAME, FILL_LAST_NAME, FILL_DEPARTMENT, FILL_SALARY);

    public static final String BOB_FIRST_NAME = "Bob";
    public static final String BOB_LAST_NAME = "Ross";
    public static final int BOB_DEPARTMENT = 0;
    public static final double BOB_SALARY = 623_001.99;

    public static final Employee BOB_EMPLOYEE = new Employee(BOB_FIRST_NAME, BOB_LAST_NAME, BOB_DEPARTMENT, BOB_SALARY);

    public static final String JONATHAN_FIRST_NAME = "Jonathan";
    public static final String JONATHAN_LAST_NAME = "Joestar";
    public static final int JONATHAN_DEPARTMENT = 2;
    public static final double JONATHAN_SALARY = 1_000_000_000.00;

    public static final Employee JONATHAN_EMPLOYEE = new Employee(JONATHAN_FIRST_NAME, JONATHAN_LAST_NAME, JONATHAN_DEPARTMENT, JONATHAN_SALARY);

    public static final Map<String, Employee> EMPLOYEE_MAP = Map.of(
            JOHN_FIRST_NAME + " " + JOHN_LAST_NAME, JOHN_EMPLOYEE,
            FILL_FIRST_NAME + " " + FILL_LAST_NAME, FILL_EMPLOYEE,
            BOB_FIRST_NAME + " " + BOB_LAST_NAME, BOB_EMPLOYEE,
            JONATHAN_FIRST_NAME + " " + JONATHAN_LAST_NAME, JONATHAN_EMPLOYEE
    );

    public static final List<Employee> EMPLOYEE_MAP_WITHOUT_FILL = List.of(
            BOB_EMPLOYEE,
            JOHN_EMPLOYEE,
            JONATHAN_EMPLOYEE

    );

    public static final List<Employee> EMPLOYEE_MAP_FROM_0_DEPARTMENT = List.of(
            BOB_EMPLOYEE,
            JOHN_EMPLOYEE
    );

    public static final List<Employee> EMPLOYEE_MAP_GROUPED_BY_DEPARTMENT = List.of(
            BOB_EMPLOYEE,
            JOHN_EMPLOYEE,
            FILL_EMPLOYEE,
            JONATHAN_EMPLOYEE
    );



    public static final Map<String, Employee> EMPTY_EMPLOYEE_MAP = Map.of();

}
