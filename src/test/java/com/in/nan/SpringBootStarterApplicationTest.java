package com.in.nan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
public class SpringBootStarterApplicationTest{
	public static void main(String[] args){
		SpringApplication.run(SpringBootStarterApplicationTest.class);
	}
}
