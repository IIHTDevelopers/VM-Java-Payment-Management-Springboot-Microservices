package org.training.order.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId; // ID of the user who placed the order

    private List<Long> productIds; // IDs of the products in the order
    private String shippingAddress; // Shipping address for the order

    private Date orderDate; // Date and time when the order was placed

}
