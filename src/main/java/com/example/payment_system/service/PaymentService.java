package com.example.payment_system.service;

import com.example.payment_system.model.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public String processPayment(final PaymentRequest request) throws InterruptedException {
        logger.info("Iniciando processamento do pagamento: {}", request.getPaymentId());

        Thread.sleep(20);  // Simula validação
        logger.info("Validação do pagamento {} concluída", request.getPaymentId());

        Thread.sleep(100); // Simula consulta ao sistema externo de pagamento
        logger.info("Consulta do pagamento {} concluída", request.getPaymentId());

        Thread.sleep(30);  // Simula gravação no banco
        logger.info("Gravação do pagamento {} no banco concluída", request.getPaymentId());

        Thread.sleep(150); // Simula confirmação de pagamento via API externa
        logger.info("Confirmação do pagamento {} concluída", request.getPaymentId());

        return request.getPaymentId();
    }

}
