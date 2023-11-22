package br.com.robytech.SystemManagentRestaurant.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.robytech.SystemManagentRestaurant.models.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionOrder;
    private double price;
    @OneToMany
    private List<Product> products = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.INACTIVE;
    private LocalDateTime dateCreation = LocalDateTime.now();

    public ServiceOrder(Long id, Client namClient, String descriptionOrder, double price, List<Product> products,
            StatusEnum status,
            LocalDateTime dateCreation) {
        this.id = id;

        this.descriptionOrder = descriptionOrder;
        this.price = price;
        this.products = products;

        this.status = status;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public void setDescriptionOrder(String descriptionOrder) {
        this.descriptionOrder = descriptionOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
