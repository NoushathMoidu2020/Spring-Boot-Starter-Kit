package com.in.nan.api;

import com.in.nan.entity.Employee;
import com.in.nan.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerMockMVCTest {
    @MockBean
    EmployeeService employeeService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testEmployeeGet() throws Exception {
        Employee employee = new Employee();
        employee.setDepartment("IT");
        employee.setName("Noushath");
        employee.setSalary(1000);
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);
        Mockito.when(employeeService.retrieveEmployees()).thenReturn(employees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":null,\"name\":\"Noushath\",\"salary\":1000,\"department\":\"IT\",\"profilePicPath\":null}]")));
    }
}
