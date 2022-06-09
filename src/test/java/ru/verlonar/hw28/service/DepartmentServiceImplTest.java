package ru.verlonar.hw28.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.verlonar.hw28.exception.EmployeeNotFoundException;
import ru.verlonar.hw28.service.impl.DepartmentServiceImpl;
import ru.verlonar.hw28.service.impl.EmployeeServiceImpl;


import static org.mockito.Mockito.when;
import static ru.verlonar.hw28.constants.EmployeeServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldCorrectGetMaximumWageEmployeeOfDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertEquals(out.getMaximumWageEmployeeOfDepartment(0), BOB_EMPLOYEE);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenGetMaximumWageEmployeeOfNonExistentDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getMaximumWageEmployeeOfDepartment(4));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenGetMaximumWageEmployeeOfDepartmentWhenMapIsEmpty() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPTY_EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getMaximumWageEmployeeOfDepartment(0));
    }

    @Test
    public void shouldCorrectGetMinimumWageEmployeeOfDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertEquals(out.getMinimumWageEmployeeOfDepartment(0), JOHN_EMPLOYEE);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenGetMinimumWageEmployeeOfOfNonExistentDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getMinimumWageEmployeeOfDepartment(6));
    }


    @Test
    public void shouldCorrectGetMinimumWageEmployeeOfDepartmentWhenMapIsEmpty() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPTY_EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getMinimumWageEmployeeOfDepartment(0));
    }

    @Test
    public void shouldCorrectGetAllEmployeesFromDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertEquals(out.getAllEmployeesFromDepartment(0), EMPLOYEE_MAP_FROM_0_DEPARTMENT);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenGetAllEmployeesFromNonExistentDepartment() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getAllEmployeesFromDepartment(8));
    }

    @Test
    public void shouldCorrectGetAllEmployeesFromDepartmentWhenMapIsEmpty() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPTY_EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getAllEmployeesFromDepartment(0));
    }

    @Test
    public void shouldCorrectGetEmployeesGroupByDepartments() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPLOYEE_MAP);

        Assertions.assertEquals(out.getEmployeesGroupByDepartments(), EMPLOYEE_MAP_GROUPED_BY_DEPARTMENT);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenGetEmployeesGroupByDepartmentsWhenMapIsEmpty() {
        when(employeeServiceMock.showAll())
                .thenReturn(EMPTY_EMPLOYEE_MAP);

        Assertions.assertThrows(EmployeeNotFoundException.class,() -> out.getEmployeesGroupByDepartments());
    }
}
