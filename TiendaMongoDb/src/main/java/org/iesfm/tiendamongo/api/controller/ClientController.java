package org.iesfm.tiendamongo.api.controller;

import org.iesfm.tiendamongo.Client;
import org.iesfm.tiendamongo.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/clients")
    public void instert(@RequestBody Client client) {
        if (clientRepository.existsById(client.getNif())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe el cliente");
        }
        clientRepository.save(client);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clientes")
    public List<Client> findByClient() {
        return clientRepository.findAll();
    }
}


