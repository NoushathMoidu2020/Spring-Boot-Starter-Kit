package com.in.nan.common.config;

import com.in.nan.SpringBootStarterApplicationTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.ANY;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(classes = SpringBootStarterApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = BEFORE_CLASS)
@AutoConfigureTestDatabase(replace = ANY)
@ActiveProfiles(profiles = "test")
public @interface CommonTestConfigAnnotations {
}
