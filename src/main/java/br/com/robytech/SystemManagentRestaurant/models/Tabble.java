package br.com.robytech.SystemManagentRestaurant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Tabble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder order;

    public Tabble(Long id, String numero, Client client, ServiceOrder order) {
        this.id = id;
        this.numero = numero;
        this.client = client;
        this.order = order;
    }

    public Tabble() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceOrder getOrder() {
        return order;
    }

    public void setOrder(ServiceOrder order) {
        this.order = order;
    }

    public String getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
