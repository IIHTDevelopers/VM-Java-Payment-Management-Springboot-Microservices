package org.training.payment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.dto.Response;
import org.training.payment.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Response> addPayment(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.addPayment(paymentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PaymentDto>> getPaymentDetailsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(paymentService.getPaymentDetailsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PaymentDto>> getAllPaymentList(Pageable pageable) {
        return new ResponseEntity<>(paymentService.getAllPaymentList(pageable), HttpStatus.OK);
    }

}
