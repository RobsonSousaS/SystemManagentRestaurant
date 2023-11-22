package br.com.robytech.SystemManagentRestaurant.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.robytech.SystemManagentRestaurant.dto.ClientDto;
import br.com.robytech.SystemManagentRestaurant.form.ClientForm;
import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<ClientDto> list(String name) {
        if (name == null) {
            List<Client> client = clientRepository.findAll();
            return ClientDto.converter(client);
        } else {
            List<Client> client = clientRepository.findByName(name);
            return ClientDto.converter(client);
        }

    }

    @PostMapping
    public ResponseEntity<ClientDto> CadasterClient(@RequestBody @Valid ClientForm form,
            UriComponentsBuilder uriBuilder) {
        Client client = form.converter();
        clientRepository.save(client);
        URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDto(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> details(@PathVariable Long id) {

        Optional<Client> optionalClient = clientRepository.findById(id);

        Client client = optionalClient.get();
        ClientDto clientDto = new ClientDto(client);
        return ResponseEntity.ok(clientDto);

    }
}
