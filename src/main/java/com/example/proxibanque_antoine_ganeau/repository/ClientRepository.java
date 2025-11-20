package com.example.proxibanque_antoine_ganeau.repository;

import com.example.proxibanque_antoine_ganeau.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByLastName(String lastName);
    Optional<Client> findByPhoneNumber(String phoneNumber);
    List<Client> findByAdvisorId(long advisorId);
}
