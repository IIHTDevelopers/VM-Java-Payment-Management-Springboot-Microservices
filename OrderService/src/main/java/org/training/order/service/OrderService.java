package org.training.order.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.training.order.model.dto.OrderDto;
import org.training.order.model.dto.Response;

import java.util.List;

public interface OrderService {

    Response addOrder(OrderDto orderDto);

    Page<OrderDto> getAllOrdersList(Pageable pageable);

    List<OrderDto> getOrderDetailsByUserId(Long userId);

}
