package ru.guzshop.catalog.api.v1.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of DTO version 1 (FOR DEMONSTRATION).
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatchOrderRequest {

    private Long count;

    private BigDecimal amount;
}
