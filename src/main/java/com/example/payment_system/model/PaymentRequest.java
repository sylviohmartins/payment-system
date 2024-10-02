package com.example.payment_system.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotNull(message = "Payment ID is required")
    @Size(min = 3, max = 50, message = "Payment ID must be between 3 and 50 characters")
    private String paymentId;

    @NotNull(message = "Customer ID is required")
    @Size(min = 3, max = 50, message = "Customer ID must be between 3 and 50 characters")
    private String customerId;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than zero")
    private Double amount;

}
