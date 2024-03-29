package br.com.robytech.SystemManagentRestaurant.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private LocalDateTime dateCreation;

    @ManyToOne
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

    public Tabble getTable() {
        return tabble;
    }

    public void setTable(Tabble table) {
        this.tabble = table;
    }

}
