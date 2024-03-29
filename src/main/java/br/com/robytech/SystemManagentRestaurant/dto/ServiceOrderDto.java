package br.com.robytech.SystemManagentRestaurant.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;
import br.com.robytech.SystemManagentRestaurant.models.enums.StatusEnum;

public class ServiceOrderDto {

    private Long id;
    private String descriptionOrder;
    private double totalPrice;
    private List<ProductDto> products;
    private StatusEnum status = StatusEnum.INACTIVE;
    private LocalDateTime dateCreation = LocalDateTime.now();
    private Tabble tabble;

    public ServiceOrderDto(ServiceOrder serviceOrder) {
        this.id = serviceOrder.getId();
        this.descriptionOrder = serviceOrder.getDescriptionOrder();
        this.totalPrice = serviceOrder.getTotalPrice();
        this.products = new ArrayList<>();
        this.products.addAll(serviceOrder.getProducts().stream().map(ProductDto::new).collect(Collectors.toList()));
        this.status = serviceOrder.getStatus();
        this.dateCreation = serviceOrder.createdServiceOrderNow(serviceOrder);
        this.tabble = serviceOrder.getTabble();
    }

    public Long getId() {
        return id;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public static List<ServiceOrderDto> converter(List<ServiceOrder> serviceOrder) {
        return serviceOrder.stream().map(ServiceOrderDto::new).collect(Collectors.toList());
    }

    public Tabble getTabble() {
        return tabble;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

}
