package br.com.robytech.SystemManagentRestaurant.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.Client;

public class DatailsClientDto {
    private Long id;
    private String name;
    private String contact;
    private LocalDateTime dataCreation;

    public DatailsClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.contact = client.getContact();
        this.dataCreation = client.createdClientNow(client);
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

}
