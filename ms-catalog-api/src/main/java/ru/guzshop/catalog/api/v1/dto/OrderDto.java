package ru.guzshop.catalog.api.v1.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guzshop.catalog.api.dto.Currency;
import ru.guzshop.catalog.api.dto.OrderStatus;

/**
 * Example of DTO version 1 (FOR DEMONSTRATION).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private UUID id;

    private String description;

    private Long count;

    private BigDecimal amount;

    private Currency currency;

    private OrderStatus status;

    private Instant createdAt;

    private Instant updatedAt;

}
