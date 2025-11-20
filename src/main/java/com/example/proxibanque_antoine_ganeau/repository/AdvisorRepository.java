package com.example.proxibanque_antoine_ganeau.repository;

import com.example.proxibanque_antoine_ganeau.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}
