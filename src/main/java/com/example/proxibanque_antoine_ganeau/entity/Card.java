package com.example.proxibanque_antoine_ganeau.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    public enum CardType {
        VISA_ELECTRON,
        VISA_PREMIER
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Card() {
        this.active = true;
    }
}
