package ru.guzshop.catalog.impl.config;

import java.util.Map;
import org.springframework.cloud.function.utils.SocketUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

/**
 * Define random port to override server.port for using feign clients
 * in integration tests without ribbon.
 */
public class RandomServerPortInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String SERVER_PORT_PROPERTY = "server.port";

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Map<String, Object> properties = Map.of(SERVER_PORT_PROPERTY, SocketUtils.findAvailableTcpPort());
        applicationContext.getEnvironment().getPropertySources()
            .addFirst(new MapPropertySource("Random Defined Server Port", properties));
    }
}
