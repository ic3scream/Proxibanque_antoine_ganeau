package com.example.proxibanque_antoine_ganeau.service;

import com.example.proxibanque_antoine_ganeau.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    Client createClient(Client client) throws Exception;
    Client updateClient(Client client);
    void deleteClient(Long id);
}
