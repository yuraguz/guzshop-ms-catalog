package ru.guzshop.catalog.api.v1.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of DTO version 1 (FOR DEMONSTRATION).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderDto {

    private List<OrderDto> items;

}
