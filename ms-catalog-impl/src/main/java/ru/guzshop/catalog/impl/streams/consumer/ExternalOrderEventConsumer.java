package ru.guzshop.catalog.impl.streams.consumer;

import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.guzshop.catalog.impl.streams.event.AbstractEvent;

/**
 * Example of implementing kafka consumers. (FOR DEMONSTRATION).
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class ExternalOrderEventConsumer {

    private final ApplicationEventPublisher eventPublisher;

    /**
     * Consumer for topic: external-order-event-topic (FOR DEMONSTRATION).
     */
    @Bean
    public Consumer<AbstractEvent> processExternalOrderEvent() {
        return event -> {

            eventPublisher.publishEvent(event);
        };
    }

}
