package org.training.order.model.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private Long paymentId;
    private Long userId;
    private Long orderId;
    private double totalAmount;
    private String paymentMethod;
    private String creditCardNumber;
}
