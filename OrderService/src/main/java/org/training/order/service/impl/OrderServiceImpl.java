package org.training.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.training.order.mapper.OrderMapper;
import org.training.order.model.dto.OrderDto;
import org.training.order.model.dto.Response;
import org.training.order.model.entity.Order;
import org.training.order.repository.OrderRepository;
import org.training.order.service.OrderService;

import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private  OrderMapper orderMapper;


    @Override
    public Response addOrder(OrderDto orderDto) {
        orderRepository.save(orderMapper.toEntity(orderDto));
        return new Response("200", "Order successfully added.");
    }

    @Override
    public Page<OrderDto> getAllOrdersList(Pageable pageable) {
        Page<Order> ordersList = orderRepository.findAll(pageable);
        return ordersList.map(orderMapper::toDto);
    }

    @Override
    public List<OrderDto> getOrderDetailsByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId).stream().map(orderMapper::toDto).toList();
    }

}
