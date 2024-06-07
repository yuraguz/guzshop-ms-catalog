package ru.guzshop.catalog.impl.model.data;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of internal data transfer object (FOR DEMONSTRATION).
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationOrderData {

    private UUID userId;

    private UUID productId;

    private BigDecimal productPrice;

    private Long productCount;

}
