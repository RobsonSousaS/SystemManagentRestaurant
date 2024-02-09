package br.com.robytech.SystemManagentRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public interface TabbleRepository extends JpaRepository<Tabble, Long> {

    Tabble getReferenceById(Long id);

}
