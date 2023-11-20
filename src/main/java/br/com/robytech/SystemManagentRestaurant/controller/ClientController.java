package br.com.robytech.SystemManagentRestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robytech.SystemManagentRestaurant.dto.ClientDto;
import br.com.robytech.SystemManagentRestaurant.form.ClientForm;
import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<ClientDto> list() {
        List<Client> client = clientRepository.findAll();
        return ClientDto.converter(client);
    }

    @PostMapping
    public void CadasterClient(@RequestBody ClientForm form) {
        Client client = form.converter();
        clientRepository.save(client);
    }

}
