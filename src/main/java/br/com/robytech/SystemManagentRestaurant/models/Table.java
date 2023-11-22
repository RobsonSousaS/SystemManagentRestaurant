package br.com.robytech.SystemManagentRestaurant.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Table {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Client> clients = new ArrayList<>();
    @OneToMany
    private List<ServiceOrder> orders = new ArrayList<>();

    public Table(Long id, List<Client> clients, List<ServiceOrder> orders) {
        this.id = id;
        this.clients = clients;
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        if (clients.size() <= 4) {
            this.clients = clients;
        } else {
            throw new IllegalArgumentException("O limite de clientes é de 4");
        }
    }

    public List<ServiceOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ServiceOrder> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
