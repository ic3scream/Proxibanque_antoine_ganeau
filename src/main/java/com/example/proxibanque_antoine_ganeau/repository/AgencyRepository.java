package com.example.proxibanque_antoine_ganeau.repository;

import com.example.proxibanque_antoine_ganeau.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Optional<Agency> findByIdentificationNumber(String identificationNumber);
}
