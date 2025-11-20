package com.example.proxibanque_antoine_ganeau.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5, unique = true, nullable = false)
    private String identificationNumber;

    private LocalDate creationDate;

    private String handlerName;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Advisor> advisor;

    public Agency() {
        this.creationDate = LocalDate.now();
    }
}
