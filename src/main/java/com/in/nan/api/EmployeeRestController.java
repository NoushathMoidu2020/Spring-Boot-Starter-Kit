package com.in.nan.api;

import com.in.nan.entity.Employee;
import com.in.nan.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeRestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        LOGGER.info("Employee Saved Successfully");
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeId}").
                buildAndExpand(newEmployee.getId()).toUri()).
                body(String.format("Employee %s saved successfully", newEmployee.getName()));
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        LOGGER.info("Employee Deleted Successfully");
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name = "employeeId") Long employeeId) {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp != null) {
            employeeService.updateEmployee(employee);
        }

    }

}
