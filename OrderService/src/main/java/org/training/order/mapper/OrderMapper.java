package org.training.order.mapper;

import org.mapstruct.Mapper;
import org.training.order.model.dto.OrderDto;
import org.training.order.model.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

}
