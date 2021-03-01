package com.in.nan.api;

import com.in.nan.dto.EmployeeDto;
import com.in.nan.entity.Employee;
import com.in.nan.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeRestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveEmployee(@RequestParam(name = "profilePic", required = true) MultipartFile profilePic,
                                               @Valid EmployeeDto employee) throws IOException {
        String profilePicPath = profilePic.getOriginalFilename() + "_" + System.currentTimeMillis();
        employee.setProfilePicPath(profilePicPath);
        try (OutputStream outputStream = Files.newOutputStream(
                Paths.get(Paths.get("").toAbsolutePath().toString(), profilePic.getOriginalFilename() + "_" + System.currentTimeMillis()))) {
            outputStream.write(profilePic.getBytes());
        }
        Employee newEmployee = employeeService.saveEmployee(employee.employeeEntityBulder());
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
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employee,
                                                 @PathVariable(name = "employeeId") Long employeeId) {
        if (employeeService.getEmployee(employeeId) != null) {
            employeeService.updateEmployee(employee.employeeEntityBulder());
            return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }

}
