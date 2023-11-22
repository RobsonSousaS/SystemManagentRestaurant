package br.com.robytech.SystemManagentRestaurant.dto;

import br.com.robytech.SystemManagentRestaurant.models.Product;
import br.com.robytech.SystemManagentRestaurant.models.enums.TypeItemEnum;

public class DatailsProductDto {

    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private TypeItemEnum typeIntemEnum;

    public DatailsProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.typeIntemEnum = product.getTypeItem();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public TypeItemEnum getTypeIntemEnum() {
        return typeIntemEnum;
    }

}
