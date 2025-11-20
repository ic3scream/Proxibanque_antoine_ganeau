package com.example.proxibanque_antoine_ganeau.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class AccountCourant extends Account {
    private double authorizedNegative;

    public AccountCourant() {
        super();
        this.authorizedNegative = 1000.0;
    }

    public AccountCourant(String numeroCompte, double solde) {
        super(numeroCompte, solde);
        this.authorizedNegative = 1000.0;
    }
    @Override
    public void withdraw(double amount) throws Exception {
        if (this.getBalance() - amount < -this.getAuthorizedNegative()) {
            throw new Exception("Not enough balance");
        }
        this.setBalance(this.getBalance() - amount);
    }
}
