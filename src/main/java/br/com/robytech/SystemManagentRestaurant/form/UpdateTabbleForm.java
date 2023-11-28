package br.com.robytech.SystemManagentRestaurant.form;

import java.util.List;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;
import br.com.robytech.SystemManagentRestaurant.repository.TabbleRepository;

public class UpdateTabbleForm {
    private long id;
    private List<Client> clients;
    private ServiceOrder order;

    public long getId() {
        return id;
    }

    public ServiceOrder getOrder() {
        return order;
    }

    public Tabble update(Long id, TabbleRepository tabbleRepository) {
        Tabble tabble = tabbleRepository.getReferenceById(id);
        tabble.setId(this.id);
        tabble.setClients(clients);
        tabble.setOrder(this.order);
        return tabble;

    }

}
