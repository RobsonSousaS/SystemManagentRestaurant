package br.com.robytech.SystemManagentRestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robytech.SystemManagentRestaurant.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

}
