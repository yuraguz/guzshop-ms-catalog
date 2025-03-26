package ru.guzshop.catalog.impl.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;

/**
 * Example of properties object class (FOR DEMONSTRATION).
 * fdafdaf fdafda fdafda
 */
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "app.ms-catalog")
public class ApplicationProperties {

    @NotNull
    private String testProperty;

    @NotNull
    private Boolean orderCreationEnabled;

    @NotNull
    private String userServiceApiVersion;

}
