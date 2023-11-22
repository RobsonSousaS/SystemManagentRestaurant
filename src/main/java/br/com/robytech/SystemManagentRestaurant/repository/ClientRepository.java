package br.com.robytech.SystemManagentRestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robytech.SystemManagentRestaurant.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);

}
