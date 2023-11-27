package br.com.robytech.SystemManagentRestaurant.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.Client;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class TabbleDto {
    private long id;
    private String numero;
    private Client client;
    private ServiceOrder serviceOrder;


    public TabbleDto(Tabble tabble) {
        this.id = tabble.getId();
        this.numero = tabble.getNumero();
        this.client = tabble.getClient();
        this.serviceOrder = tabble.getOrder();
    
    }

    public long getId() {
        return id;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;

    }

    public static List<TabbleDto> converter(List<Tabble> tabble) {
        return tabble.stream().map(TabbleDto::new).collect(Collectors.toList());
    }

    public String getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

}
