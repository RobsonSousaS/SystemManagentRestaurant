package br.com.robytech.SystemManagentRestaurant.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ClientDto {
    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String contact;
    @NotNull @NotEmpty
    private LocalDateTime dataCreation;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.contact = client.getContact();
        this.dataCreation = client.createdClientNow();
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

    public static List<ClientDto> converter(List<Client> client) {
        return client.stream().map(ClientDto::new).collect(Collectors.toList());
    }

}
