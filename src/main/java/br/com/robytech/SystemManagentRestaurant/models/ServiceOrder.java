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
import jakarta.persistence.OneToOne;

@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descriptionOrder;
    private double totalPrice;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.INACTIVE;

    private LocalDateTime dateCreation = LocalDateTime.now();

    @OneToOne
    private Tabble tabble;

    public ServiceOrder(Long id, String descriptionOrder, List<Product> products,
            StatusEnum status,
            LocalDateTime dateCreation, Tabble tabble) {
        this.id = id;
        this.descriptionOrder = descriptionOrder;
        this.products = products;
        this.status = status;
        this.dateCreation = dateCreation;
        this.tabble = tabble;
    }

    public ServiceOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public void CalcTotalPrice() {
        double total = 0.0;

        for (Product product : products) {
            total += product.getPrice();
        }
        this.totalPrice = total;
    }

    public LocalDateTime createdServiceOrderNow(ServiceOrder serviceOrder) {
        return serviceOrder.getDateCreation();
    }

    public Tabble getTabble() {
        return tabble;
    }

}
