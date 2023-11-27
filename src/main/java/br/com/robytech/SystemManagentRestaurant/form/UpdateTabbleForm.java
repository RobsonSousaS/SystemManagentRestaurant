package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;
import br.com.robytech.SystemManagentRestaurant.repository.TabbleRepository;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

public class UpdateTabbleForm {
    private long id;
    @NonNull
    @NotEmpty
    private Client client;
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
        tabble.setClient(this.client);
        tabble.setOrder(this.order);
        return tabble;

    }

}
