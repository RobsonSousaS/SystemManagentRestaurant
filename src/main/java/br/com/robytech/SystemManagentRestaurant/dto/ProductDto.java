package br.com.robytech.SystemManagentRestaurant.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.Product;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
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

    public static List<ProductDto> converter(List<Product> product) {
        return product.stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
