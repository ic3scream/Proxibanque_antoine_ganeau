package com.example.proxibanque_antoine_ganeau.service;

import com.example.proxibanque_antoine_ganeau.entity.*;
import com.example.proxibanque_antoine_ganeau.repository.AdvisorRepository;
import com.example.proxibanque_antoine_ganeau.repository.AgencyRepository;
import com.example.proxibanque_antoine_ganeau.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AdvisorRepository advisorRepository;
    private final AgencyRepository agencyRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Client client) throws Exception {
        if (client.getAdvisor() != null && client.getAdvisor().getId() != null) {
            Advisor advisor = advisorRepository.findById(client.getAdvisor().getId())
                    .orElseThrow(() -> new Exception("Advisor not found"));

            if (!advisor.canAssignNewClient()) {
                throw new Exception("Cannot assign new client, limit reached");
            }
        }

        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @PostConstruct
    private void initDB() {
        if (clientRepository.count() > 0) {
            return;
        }

        Agency agency = new Agency();
        agency.setIdentificationNumber("ABC01");
        agency = agencyRepository.save(agency);
        Advisor advisor = new Advisor();
        advisor.setLastName("Antoine");
        advisor.setFirstName("Ganeau");
        advisor.setAgency(agency);
        advisorRepository.save(advisor);

        Client clientA = new Client();
        clientA.setLastName("Roman");
        clientA.setFirstName("Morliere");
        clientA.setAdvisor(advisor);

        AccountCourant accountA = new AccountCourant();
        accountA.setAccountNumber("C1");
        accountA.setBalance(2000.0);
        accountA.setAuthorizedNegative(1000.0);
        clientA.setCompteCourant(accountA);

        Client clientB = new Client();
        clientB.setLastName("Michael");
        clientB.setFirstName("Rousseau");
        clientB.setAdvisor(advisor);

        AccountEpargne accountB = new AccountEpargne();
        accountB.setAccountNumber("E1");
        accountB.setBalance(500.0);
        accountB.setApy(0.03);
        clientB.setCompteEpargne(accountB);

        clientRepository.saveAll(List.of(clientA, clientB));

    }
}
