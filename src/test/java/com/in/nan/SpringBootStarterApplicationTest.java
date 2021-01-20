package com.in.nan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
public class SpringBootStarterApplicationTest{
	public static void main(String[] args){
		SpringApplication.run(SpringBootStarterApplicationTest.class);
	}
}
