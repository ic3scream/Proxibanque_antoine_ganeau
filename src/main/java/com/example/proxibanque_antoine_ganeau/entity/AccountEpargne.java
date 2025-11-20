package com.example.proxibanque_antoine_ganeau.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountEpargne extends Account {
    private double apy;
    public AccountEpargne() {
        super();
        this.apy = 0.03;
    }

    public AccountEpargne(String numeroCompte, double solde) {
        super(numeroCompte, solde);
        this.apy = 0.03;
    }

    public double getApy() {
        return apy;
    }

    public void setApy(double apy) {
        this.apy = apy;
    }
}
