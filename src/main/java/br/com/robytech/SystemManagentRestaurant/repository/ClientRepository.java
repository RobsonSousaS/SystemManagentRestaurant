package br.com.robytech.SystemManagentRestaurant.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robytech.SystemManagentRestaurant.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByName(String name, Pageable pages);

    Client getReferenceById(Long id);

}
