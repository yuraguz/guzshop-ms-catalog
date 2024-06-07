package ru.guzshop.catalog.impl.model.data;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of internal transfer data object (FOR DEMONSTRATION).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchOrderData {

    private Long count;

    private BigDecimal amount;
}
