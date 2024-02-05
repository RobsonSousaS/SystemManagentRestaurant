package br.com.robytech.SystemManagentRestaurant.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class TabbleDto {
    private long id;
    private String numero;
    List<ClientDto> clients;
    private ServiceOrder serviceOrder;

    public TabbleDto(Tabble tabble) {
        this.id = tabble.getId();
        this.numero = tabble.getNumero();
        this.clients = new ArrayList<>();
        this.clients.addAll(tabble.getClients().stream().map(ClientDto::new).collect(Collectors.toList()));
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

    public List<ClientDto> getClients() {
        return clients;
    }

}
