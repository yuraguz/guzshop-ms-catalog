package ru.guzshop.catalog.api.config;

import org.springframework.context.annotation.Configuration;

/**
 * Example of configuring feign client (FOR DEMONSTRATION).
 * <p/>
 * Autoconfigure enabled via:
 * 1. spring.factories - legacy
 * 2. /META-INF/spring/...AutoConfiguration.imports - since spring boot 3
 */
@Configuration
//@EnableFeignClients(basePackageClasses = OrderClient.class)
public class FeignConfig {

}
