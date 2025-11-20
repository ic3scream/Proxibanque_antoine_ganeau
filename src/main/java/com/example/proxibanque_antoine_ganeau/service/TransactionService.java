package com.example.proxibanque_antoine_ganeau.service;

import com.example.proxibanque_antoine_ganeau.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public interface TransactionService {
    public void makeTransaction(String fromAccountNumber, String toAccountNumber, double amount) throws Exception;
}
