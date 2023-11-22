package br.com.robytech.SystemManagentRestaurant.models;

import br.com.robytech.SystemManagentRestaurant.models.enums.TypeItemEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    @Enumerated(EnumType.STRING)
    private TypeItemEnum typeItem = TypeItemEnum.EMPTY;

    public Product(Long id, String name, String description, int quantity, double price, TypeItemEnum typeItem) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.typeItem = typeItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeItemEnum getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItemEnum typeItem) {
        this.typeItem = typeItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
