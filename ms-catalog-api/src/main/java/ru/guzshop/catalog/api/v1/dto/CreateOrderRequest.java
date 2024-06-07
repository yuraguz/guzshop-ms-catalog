package ru.guzshop.catalog.api.v1.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guzshop.catalog.api.dto.Currency;

/**
 * Example of DTO version 1 (FOR DEMONSTRATION).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private String description;

    private Long count;

    private BigDecimal amount;

    private Currency currency;
}
