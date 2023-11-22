package br.com.robytech.SystemManagentRestaurant.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.robytech.SystemManagentRestaurant.dto.DatailsProductDto;
import br.com.robytech.SystemManagentRestaurant.dto.ProductDto;
import br.com.robytech.SystemManagentRestaurant.form.ProductForm;
import br.com.robytech.SystemManagentRestaurant.models.Product;
import br.com.robytech.SystemManagentRestaurant.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductDto> getProduct(String name) {
        if (name == null) {
            List<Product> product = productRepository.findAll();
            return ProductDto.converter(product);
        } else {
            List<Product> product = productRepository.findByName(name);
            return ProductDto.converter(product);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatailsProductDto> detailsProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(new DatailsProductDto(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> cadasterProduct(@RequestBody @Valid ProductForm form,
            UriComponentsBuilder uriBuilder) {
        Product product = form.converter();
        productRepository.save(product);
        URI uri = uriBuilder.path("/table/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
