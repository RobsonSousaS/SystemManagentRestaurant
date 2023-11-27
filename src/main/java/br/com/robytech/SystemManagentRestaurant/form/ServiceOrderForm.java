package br.com.robytech.SystemManagentRestaurant.form;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.robytech.SystemManagentRestaurant.models.Product;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;
import br.com.robytech.SystemManagentRestaurant.models.enums.StatusEnum;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

public class ServiceOrderForm {
    private Long id;
    @NonNull
    @NotEmpty
    private Tabble tabble;
    private String descriptionOrder;
    private double totalPrice;
    private List<Product> products = new ArrayList<>();
    @NonNull
    @NotEmpty
    private StatusEnum status = StatusEnum.INACTIVE;
    private LocalDateTime dateCreation;

    public Long getId() {
        return id;
    }

    public Tabble getTabble() {
        return tabble;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public ServiceOrder converter() {
        return new ServiceOrder(id, descriptionOrder, products, status, dateCreation);
    }

}
