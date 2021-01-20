package com.in.nan.service;
import com.in.nan.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> retrieveEmployees();

    Employee getEmployee(Long employeeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    void updateEmployee(Employee employee);
}
