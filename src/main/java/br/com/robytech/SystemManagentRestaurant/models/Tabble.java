package br.com.robytech.SystemManagentRestaurant.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Tabble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @OneToMany(mappedBy = "tabble")
    private List<Client> clients = new ArrayList<>();

    @OneToOne
    private ServiceOrder order;

    public Tabble(Long id, String numero, List<Client> clients, ServiceOrder order) {
        this.id = id;
        this.numero = numero;
        this.clients = clients;
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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Client> getClients() {
        if (clients == null) {
            clients = new ArrayList<>();
        }
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
