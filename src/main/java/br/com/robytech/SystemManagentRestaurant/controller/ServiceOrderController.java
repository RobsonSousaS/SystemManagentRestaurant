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

import br.com.robytech.SystemManagentRestaurant.dto.ServiceOrderDto;
import br.com.robytech.SystemManagentRestaurant.form.ServiceOrderForm;
import br.com.robytech.SystemManagentRestaurant.models.ServiceOrder;

import br.com.robytech.SystemManagentRestaurant.repository.ServiceOrderRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
@Validated
public class ServiceOrderController {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @GetMapping
    public List<ServiceOrderDto> getServiceOrder() {
        List<ServiceOrder> serviceOrder = serviceOrderRepository.findAll();
        return ServiceOrderDto.converter(serviceOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDto> detailsOrder(@PathVariable Long id) {
        Optional<ServiceOrder> order = serviceOrderRepository.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok(new ServiceOrderDto(order.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ServiceOrderDto> CadasterTabble(@RequestBody @Valid ServiceOrderForm form,
            UriComponentsBuilder uriBuilder) {
        ServiceOrder serviceOrder = form.converter();
        serviceOrderRepository.save(serviceOrder);
        URI uri = uriBuilder.path("/table/{id}").buildAndExpand(serviceOrder.getId()).toUri();
        return ResponseEntity.created(uri).body(new ServiceOrderDto(serviceOrder));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<ServiceOrder> optional = serviceOrderRepository.findById(id);
        if (optional.isPresent()) {
            serviceOrderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
