package ru.guzshop.catalog.impl.streams.event;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of external domain event (FOR DEMONSTRATION).
 * <p></p>
 * NOTE: This class should not be in project but came from external API async JAR module.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalOrderEvent {

    private UUID orderId;

    private String description;

    private EventType type;

    public enum EventType {
        ORDER_REJECTED,
        ORDER_APPROVED
    }
}
