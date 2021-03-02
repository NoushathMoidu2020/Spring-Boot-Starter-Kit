package com.in.nan.service.impl;

import com.in.nan.common.config.CommonTestConfigAnnotations;
import com.in.nan.entity.Employee;
import com.in.nan.repository.EmployeeRepository;
import com.in.nan.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfigAnnotations
public class EmployeeServiceImplTest {
    @MockBean
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;

    @Test
    public void retrieveEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setDepartment("IT");
        employee.setName("Noushath");
        employee.setSalary(1000);
        employeeList.add(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        Assert.assertEquals("Employee names are not matching", employeeList.get(0).getName(),
                employeeService.retrieveEmployees().get(0).getName());
    }
}
