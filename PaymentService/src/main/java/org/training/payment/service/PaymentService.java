package org.training.payment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.dto.Response;
import org.training.payment.model.entity.Payment;

import java.util.List;

public interface PaymentService {

    Response addPayment(PaymentDto orderDto);

    Page<PaymentDto> getAllPaymentList(Pageable pageable);

    List<PaymentDto> getPaymentDetailsByUserId(Long userId);

}
