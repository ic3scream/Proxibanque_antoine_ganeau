package com.example.proxibanque_antoine_ganeau.service.gestion;

import com.example.proxibanque_antoine_ganeau.entity.Account;

public class NYInvest implements Investment {
    @Override
    public void invest(Account account, double amount) throws Exception {
        System.out.println("Investing " + amount + " euros on the New York exchange");
        account.withdraw(amount);
        System.out.println("Investment successful!");
    }
}
