package com.example.proxibanque_antoine_ganeau.service;

import com.example.proxibanque_antoine_ganeau.entity.Account;
import com.example.proxibanque_antoine_ganeau.entity.AccountCourant;
import com.example.proxibanque_antoine_ganeau.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepository accountRepository;

    @Override
    public void makeTransaction(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account from = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new Exception("Issuer account not found"));

        Account to = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new Exception("Recipient account not found"));
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (from instanceof AccountCourant) {
            AccountCourant cc = (AccountCourant) from;
            if (cc.getBalance() - amount < -cc.getAuthorizedNegative()) {
                throw new Exception("Balance too low (courant)");
            }
        } else {
            if (from.getBalance() < amount) {
                throw new Exception("Balance too low (epargne)");
            }
        }
    }
}
