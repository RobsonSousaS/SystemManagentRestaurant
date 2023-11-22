package br.com.robytech.SystemManagentRestaurant.form;

import java.time.LocalDateTime;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ClientForm {

    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    private LocalDateTime dataCreation;
    @NotNull
    @NotEmpty
    private String contact;

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

    public Client converter() {

        return new Client(id, name, contact, dataCreation);
    }

}
