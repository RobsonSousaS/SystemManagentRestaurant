package br.com.robytech.SystemManagentRestaurant.dto;

import java.time.LocalDateTime;


import org.springframework.data.domain.Page;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class ClientDto {
    private Long id;
    private String name;
    private String contact;
    private LocalDateTime dataCreation;
    private Tabble tabble;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.contact = client.getContact();
        this.dataCreation = client.createdClientNow(client);
        this.tabble = client.getTable();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public LocalDateTime getDataCreation() {
        return dataCreation;
    }

    public Tabble getTabble() {
        return tabble;
    }

    public static Page<ClientDto> converter(Page<Client> client) {
        return client.map(ClientDto::new);
    }

}
