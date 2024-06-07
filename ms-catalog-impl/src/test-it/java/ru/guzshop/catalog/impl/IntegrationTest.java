package ru.guzshop.catalog.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import ru.guzshop.catalog.api.config.FeignConfig;
import ru.guzshop.catalog.impl.config.RandomServerPortInitializer;

/**
 * User for testing controllers or services with: 1) Running embedded server (Tomcat) 2)
 * Testcontainers
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({TestChannelBinderConfiguration.class, FeignConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWireMock(port = 0)
@ContextConfiguration(initializers = RandomServerPortInitializer.class)
public @interface IntegrationTest {

}
