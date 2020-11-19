package com.in.nan.service;
import com.in.nan.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> retrieveEmployees();

    public Employee getEmployee(Long employeeId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}
