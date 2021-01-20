package com.in.nan.api;

import com.in.nan.common.config.CommonTestConfigAnnotations;
import com.in.nan.common.config.CommonTestConfigBeans;
import com.in.nan.entity.Employee;
import com.jayway.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.http.ContentType.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@CommonTestConfigAnnotations
public class EmployeeRestControllerTest extends CommonTestConfigBeans {

    @Test
    public void testEmployeeCrud(){
        Employee employee = new Employee();
        employee.setDepartment("IT");
        employee.setName("Noushath");
        employee.setSalary(1000);
        // create
        RestAssured.given().auth().none().
                contentType(JSON)
                .body(employee)
                .log().all()
                .expect().statusCode(HttpStatus.CREATED.value()).log().all()
                .when().post("/api/employees/").asString();
        // read
        employee.setId(1l);
        RestAssured.given().auth().none().
                contentType(JSON)
                .log().all()
                .expect().statusCode(HttpStatus.OK.value()).log().all()
                .when().get("/api/employees/{employeeId}/", employee.getId()).asString();
        // read all
        RestAssured.given().auth().none().
                contentType(JSON)
                .log().all()
                .expect().statusCode(HttpStatus.OK.value()).log().all()
                .when().get("/api/employees/").asString();
        // read all
        employee.setSalary(20000);
        //update
        RestAssured.given().auth().none().
                contentType(JSON).body(employee)
                .log().all()
                .expect().statusCode(HttpStatus.OK.value()).log().all()
                .when().put("/api/employees/{employeeId}/",employee.getId()).asString();
        //delete
        RestAssured.given().auth().none().
                contentType(JSON)
                .log().all()
                .expect().statusCode(HttpStatus.OK.value()).log().all()
                .when().delete("/api/employees/{employeeId}/",employee.getId()).asString();

    }
}
