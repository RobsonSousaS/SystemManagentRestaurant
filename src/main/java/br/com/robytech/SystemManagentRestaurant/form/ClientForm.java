package br.com.robytech.SystemManagentRestaurant.form;

import java.time.LocalDateTime;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class ClientForm {

    private Long id;
    private String name;
    private LocalDateTime dateCreation;
    private String contact;
    private Tabble tabble;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Client converter() {
        return new Client(id, name, contact, dateCreation, tabble);
    }

}
