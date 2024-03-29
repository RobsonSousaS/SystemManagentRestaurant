package br.com.robytech.SystemManagentRestaurant.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.robytech.SystemManagentRestaurant.dto.ClientDto;
import br.com.robytech.SystemManagentRestaurant.dto.DatailsClientDto;
import br.com.robytech.SystemManagentRestaurant.form.ClientForm;
import br.com.robytech.SystemManagentRestaurant.form.UpdateClientForm;
import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.repository.ClientRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public Page<ClientDto> getClient(@RequestParam(required =  false) String name, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 20) Pageable ordering) {


        if (name == null) {
            Page<Client> client = clientRepository.findAll(ordering);
            return ClientDto.converter(client);
        } else {
            Page<Client> client = clientRepository.findByName(name, ordering);
            return ClientDto.converter(client);
        }

    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDto> cadasterClient(@RequestBody @Valid ClientForm form,
            UriComponentsBuilder uriBuilder) {
        Client client = form.converter();
        clientRepository.save(client);
        URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDto(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatailsClientDto> detailsClient(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(new DatailsClientDto(client.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody @Valid UpdateClientForm form) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            Client client = form.update(id, clientRepository);
            return ResponseEntity.ok(new ClientDto(client));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
