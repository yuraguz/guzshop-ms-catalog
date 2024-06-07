package ru.guzshop.catalog.impl.config;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * Postgres testcontainer configuration (FOR DEMONSTRATION).
 */
//@Configuration
public class PostgresContainerConfiguration {

    private static final String IMAGE_POSTGRES = "postgres:15.1";

    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgreSQLContainer() {
        System.out.println("Привет!");

        return new PostgreSQLContainer<>(DockerImageName.parse(IMAGE_POSTGRES))
            .withUsername("testUser")


            .withPassword("testPassword")
            .withDatabaseName("testDatabase");



    }


}
