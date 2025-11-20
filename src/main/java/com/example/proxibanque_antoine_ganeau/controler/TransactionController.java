package com.example.proxibanque_antoine_ganeau.controler;

import com.example.proxibanque_antoine_ganeau.service.TransactionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/transfer")
    public ResponseEntity<String> makeTransfer(@RequestBody TransferPayload payload) {
        try {
            service.makeTransaction(
                    payload.getFromAccountNumber(),
                    payload.getToAccountNumber(),
                    payload.getAmount()
            );
            return ResponseEntity.ok("Transfer successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Data
    static class TransferPayload {
        private String fromAccountNumber;
        private String toAccountNumber;
        private double amount;
    }
}
