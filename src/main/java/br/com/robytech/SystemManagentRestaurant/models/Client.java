package br.com.robytech.SystemManagentRestaurant.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    @OneToMany
    private List<ServiceOrder> orders = new ArrayList<>();
    private LocalDateTime dataCreation = LocalDateTime.now();

    public Client() {
    }

    public Client(Long id, String name, String contact, LocalDateTime dataCreation) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.dataCreation = dataCreation;
    }

    public List<ServiceOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ServiceOrder> orders) {
        this.orders = orders;
    }

    public LocalDateTime getDataCreation() {
        return dataCreation;
    }

    public void setDataCreation(LocalDateTime dataCreation) {
        this.dataCreation = dataCreation;
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

}
