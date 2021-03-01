package com.in.nan.dto;

import com.in.nan.entity.Employee;
import io.swagger.annotations.ApiModelProperty;

public class EmployeeDto {

    @ApiModelProperty(hidden = true)
    private Long id;


    private String name;


    private Integer salary;


    private String department;


    @ApiModelProperty(hidden = true)
    private String profilePicPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public Employee employeeEntityBulder() {
        Employee employee = new Employee();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setDepartment(this.department);
        employee.setSalary(this.salary);
        employee.setProfilePicPath(this.profilePicPath);
        return employee;
    }
}
