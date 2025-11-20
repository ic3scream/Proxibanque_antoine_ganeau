package com.example.proxibanque_antoine_ganeau.service.gestion;

import com.example.proxibanque_antoine_ganeau.entity.Account;

public interface Investment {
    void invest(Account account, double amount) throws Exception;
}
