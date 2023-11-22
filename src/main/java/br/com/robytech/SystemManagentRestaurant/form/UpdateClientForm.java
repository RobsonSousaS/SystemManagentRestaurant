package br.com.robytech.SystemManagentRestaurant.form;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.com.robytech.SystemManagentRestaurant.dto.ClientDto;
import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.repository.ClientRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateClientForm {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Client update(Long id, ClientRepository clientRepository) {
        Client client = clientRepository.getReferenceById(id);
        client.setName(this.name);
        client.setContact(this.contact);
        return client;
        
            
        
    }

    
}
