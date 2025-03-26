package ru.guzshop.catalog.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.guzshop.catalog.api.v1.dto.CreateOrderRequest;
import ru.guzshop.catalog.api.v1.dto.OrderDto;
import ru.guzshop.catalog.api.v1.dto.PatchOrderRequest;
import ru.guzshop.catalog.api.v1.dto.RegisterOrderRequest;
import ru.guzshop.catalog.impl.model.data.PatchOrderData;
import ru.guzshop.catalog.impl.model.data.RegistrationOrderData;
import ru.guzshop.catalog.impl.model.entity.Order;

/**
 * Example of implementation mapstruct mapper (FOR DEMONSTRATION).
 * fdafdafda.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    List<OrderDto> orderToOrderDto(List<Order> orders);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    Order createOrderRequestToOrder(CreateOrderRequest request);

    PatchOrderData patchOrderRequestToData(PatchOrderRequest request);

    RegistrationOrderData registerOrderRequestToData(RegisterOrderRequest request);

}
