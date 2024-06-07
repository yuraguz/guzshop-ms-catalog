package ru.guzshop.catalog.impl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.guzshop.catalog.impl.properties.ApplicationProperties;

/**
 * Service that serves specific business logic (FOR DEMONSTRATION).
 * Ideal candidate for unit tests.
 */
@Service
@RequiredArgsConstructor
public class OrderPoliciesService {

    private final ApplicationProperties applicationProperties;

    /**
     * Properties usage demonstration.
     */
    public boolean isOrderCreationAllowed() {
        return applicationProperties.getOrderCreationEnabled();
    }

}
