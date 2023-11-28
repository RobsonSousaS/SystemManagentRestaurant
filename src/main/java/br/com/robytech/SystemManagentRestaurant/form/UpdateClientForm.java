package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;
import br.com.robytech.SystemManagentRestaurant.repository.ClientRepository;

public class UpdateClientForm {

    private String name;
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
