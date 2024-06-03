package org.training.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.order.model.dto.OrderDto;
import org.training.order.model.dto.Response;
import org.training.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Response> addOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.addOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> getOrderDetailsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(orderService.getOrderDetailsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<OrderDto>> getAllOrdersList(Pageable pageable) {
        return new ResponseEntity<>(orderService.getAllOrdersList(pageable), HttpStatus.OK);
    }

}
