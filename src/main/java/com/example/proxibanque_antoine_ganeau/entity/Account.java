package com.example.proxibanque_antoine_ganeau.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private double balance;
    private LocalDate dateOpened;

    public Account() {
        this.dateOpened = LocalDate.now();
    }

    public Account(String numeroCompte, double balance) {
        this.accountNumber = numeroCompte;
        this.balance = balance;
        this.dateOpened = LocalDate.now();
    }
}
