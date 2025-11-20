package com.example.proxibanque_antoine_ganeau.controler;

import com.example.proxibanque_antoine_ganeau.entity.Client;
import com.example.proxibanque_antoine_ganeau.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return service.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) throws Exception {
        return service.createClient(client);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        try {
            return ResponseEntity.ok(service.updateClient(client));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
