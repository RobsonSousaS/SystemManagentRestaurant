package br.com.robytech.SystemManagentRestaurant.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    private LocalDateTime dateCreation;
    @OneToOne
    private Tabble tabble;

    public Client() {
    }

    public Client(Long id, String name, String contact, LocalDateTime dateCreation, Tabble tabble) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.dateCreation = LocalDateTime.now();
        this.tabble = tabble;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime createdClientNow(Client client) {
        return client.getDateCreation();
    }

    public Tabble getTabble() {
        return tabble;
    }

}
