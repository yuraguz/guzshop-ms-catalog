package ru.guzshop.catalog.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * User for testing repositories without running embedded server (only testcontainers)
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@EnableJpaRepositories(basePackageClasses = OrderRepository.class)
public @interface RepositoryTest {

}
