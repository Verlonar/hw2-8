package ru.verlonar.hw28.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.exception.EmployeeIsAlreadyExistException;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.impl.EmployeeServiceImpl;

import java.util.stream.Stream;

import static ru.verlonar.hw28.constants.EmployeeServiceImplTestConstants.*;
import static ru.verlonar.hw28.constants.EmployeeServiceImplTestConstants.JONATHAN_DEPARTMENT;

public class EmployeeServiceImplTest {
    EmployeeService out = new EmployeeServiceImpl();

    @BeforeEach
    public void clearEmployees() {
        try {
            out.deleteEmployee(JOHN_FIRST_NAME, JOHN_LAST_NAME);
        } catch (Exception ignored) {

        }
        try {
            out.deleteEmployee(FILL_FIRST_NAME, FILL_LAST_NAME);
        } catch (Exception ignored) {

        }try {
            out.deleteEmployee(BOB_FIRST_NAME, BOB_LAST_NAME);
        } catch (Exception ignored) {

        }
        try {
            out.deleteEmployee(JONATHAN_FIRST_NAME, JONATHAN_LAST_NAME);
        } catch (Exception ignored) {

        }
    }

    @ParameterizedTest
    @MethodSource("employeesForAddDeleteFindTests")
    public void shouldCorrectAddEmployee(String firstName, String lastName, int department, double salary, Employee expectedResult) {
        Employee result = out.addEmployee(firstName, lastName, department, salary);
        Assertions.assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("employeesForExceptionAddTests")
    public void shouldThrowEmployeeIsAlreadyExistExceptionWhenAddEmployee(String firstName, String lastName, int department, double salary) {
        out.addEmployee(firstName, lastName, department, salary);
        Assertions.assertThrows(EmployeeIsAlreadyExistException.class, () -> out.addEmployee(firstName, lastName, department, salary));
    }

    @ParameterizedTest
    @MethodSource("employeesForAddDeleteFindTests")
    public void shouldCorrectDeleteEmployee(String firstName, String lastName, int department, double salary, Employee expectedResult) {
        out.addEmployee(firstName, lastName, department, salary);
        Employee result = out.deleteEmployee(firstName, lastName);
        Assertions.assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("employeesForExceptionDeleteFindTests")
    public void shouldThrowEmployeeNotFoundExceptionWhenDeleteEmployee(String firstName, String lastName) {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.deleteEmployee(firstName, lastName));
    }

    @ParameterizedTest
    @MethodSource("employeesForAddDeleteFindTests")
    public void shouldCorrectFindEmployee(String firstName, String lastName, int department, double salary, Employee expectedResult) {
        out.addEmployee(firstName, lastName, department, salary);
        Employee result = out.findEmployee(firstName, lastName);
        Assertions.assertEquals(result, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("employeesForExceptionDeleteFindTests")
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee(String firstName, String lastName) {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(firstName, lastName));
    }

    private static Stream<Arguments> employeesForAddDeleteFindTests() {
        return Stream.of(
                Arguments.of(JOHN_FIRST_NAME, JOHN_LAST_NAME, JOHN_DEPARTMENT, JOHN_SALARY, JOHN_EMPLOYEE),
                Arguments.of(FILL_FIRST_NAME, FILL_LAST_NAME, FILL_DEPARTMENT, FILL_SALARY, FILL_EMPLOYEE),
                Arguments.of(BOB_FIRST_NAME, BOB_LAST_NAME, BOB_DEPARTMENT, BOB_SALARY, BOB_EMPLOYEE),
                Arguments.of(JONATHAN_FIRST_NAME, JONATHAN_LAST_NAME, JONATHAN_DEPARTMENT, JONATHAN_SALARY, JONATHAN_EMPLOYEE)
        );
    }

    private static Stream<Arguments> employeesForExceptionAddTests() {
        return Stream.of(
                Arguments.of(JOHN_FIRST_NAME, JOHN_LAST_NAME, JOHN_DEPARTMENT, JOHN_SALARY),
                Arguments.of(FILL_FIRST_NAME, FILL_LAST_NAME, FILL_DEPARTMENT, FILL_SALARY),
                Arguments.of(BOB_FIRST_NAME, BOB_LAST_NAME, BOB_DEPARTMENT, BOB_SALARY),
                Arguments.of(JONATHAN_FIRST_NAME, JONATHAN_LAST_NAME, JONATHAN_DEPARTMENT, JONATHAN_SALARY)
        );
    }

    private static Stream<Arguments> employeesForExceptionDeleteFindTests() {
        return Stream.of(
                Arguments.of(JOHN_FIRST_NAME, JOHN_LAST_NAME),
                Arguments.of(FILL_FIRST_NAME, FILL_LAST_NAME),
                Arguments.of(BOB_FIRST_NAME, BOB_LAST_NAME),
                Arguments.of(JONATHAN_FIRST_NAME, JONATHAN_LAST_NAME)
        );
    }
}
