package org.training.order.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.training.order.model.dto.OrderDto;
import org.training.order.model.entity.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T15:19:12+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setUserId( orderDto.getUserId() );
        List<Long> list = orderDto.getProductIds();
        if ( list != null ) {
            order.setProductIds( new ArrayList<Long>( list ) );
        }
        order.setShippingAddress( orderDto.getShippingAddress() );
        order.setOrderDate( orderDto.getOrderDate() );

        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderDate( order.getOrderDate() );
        List<Long> list = order.getProductIds();
        if ( list != null ) {
            orderDto.setProductIds( new ArrayList<Long>( list ) );
        }
        orderDto.setShippingAddress( order.getShippingAddress() );
        orderDto.setUserId( order.getUserId() );

        return orderDto;
    }
}
