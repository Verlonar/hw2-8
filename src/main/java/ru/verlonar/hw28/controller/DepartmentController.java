package ru.verlonar.hw28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.verlonar.hw28.data.Employee;
import ru.verlonar.hw28.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaximumWageEmployeeOfDepartment(@RequestParam int departmentId) {
        return departmentService.getMaximumWageEmployeeOfDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinimumWageEmployeeOfDepartment(@RequestParam int departmentId) {
        return departmentService.getMinimumWageEmployeeOfDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesFromDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getAllEmployeesFromDepartment(departmentId);
        } else {
            return departmentService.getEmployeesGroupByDepartments();
        }
    }
}
