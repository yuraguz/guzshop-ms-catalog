package ru.guzshop.catalog.impl.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.guzshop.catalog.impl.properties.ApplicationProperties;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class PropertiesConfig {
}
