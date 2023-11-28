package br.com.robytech.SystemManagentRestaurant.form;

import java.util.List;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class TabbleForm {
    private long id;
    private String numero;
    List<Client> clients;
    private ServiceOrder order;

    public long getId() {
        return id;
    }

    public ServiceOrder getOrder() {
        return order;
    }

    public Tabble converter() {
        return new Tabble(id, numero, clients, order);
    }

    public String getNumero() {
        return numero;
    }

    public List<Client> getClients() {
        return clients;
    }

}
