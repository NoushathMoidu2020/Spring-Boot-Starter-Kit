package com.in.nan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Profile("dev")
public class SpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }

}
