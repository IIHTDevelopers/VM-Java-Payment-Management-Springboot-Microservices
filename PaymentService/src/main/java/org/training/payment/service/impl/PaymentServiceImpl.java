package org.training.payment.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.payment.exception.ResourceNotFound;
import org.training.payment.external.UserService;
import org.training.payment.mapper.PaymentMapper;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.dto.Response;
import org.training.payment.model.dto.UserDto;
import org.training.payment.model.entity.Payment;
import org.training.payment.repository.PaymentRepository;
import org.training.payment.service.PaymentService;

import java.util.List;

@Service

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private  PaymentMapper paymentMapper;

    @Autowired
    private UserService userService;


    @Override
    public Response addPayment(PaymentDto paymentDto) {
        paymentRepository.save(paymentMapper.toEntity(paymentDto));
        return new Response("200", "Payment successfully added.");
    }

    @Override
    public Page<PaymentDto> getAllPaymentList(Pageable pageable) {
        Page<Payment> paymentList = paymentRepository.findAll(pageable);
        return paymentList.map(paymentMapper::toDto);
    }

    @Override
    public List<PaymentDto> getPaymentDetailsByUserId(Long userId) {
        return paymentRepository.findAllByUserId(userId).stream().map(paymentMapper::toDto).toList();
    }

}
