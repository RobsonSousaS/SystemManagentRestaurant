package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.Product;
import br.com.robytech.SystemManagentRestaurant.models.enums.TypeItemEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductForm {

    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private int quantity;
    @NotNull
    @NotEmpty
    private double price;
   

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


    public Product converter() {
        return new Product(id, name, description, quantity, price, null);
    }

}
