package com.example.payment_system.controller;

import com.example.payment_system.model.PaymentRequest;
import com.example.payment_system.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String processPayment(@Valid @RequestBody PaymentRequest request) throws InterruptedException {
        return paymentService.processPayment(request);
    }

}
