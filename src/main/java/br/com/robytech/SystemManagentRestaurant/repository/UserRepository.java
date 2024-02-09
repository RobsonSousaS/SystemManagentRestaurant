package br.com.robytech.SystemManagentRestaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robytech.SystemManagentRestaurant.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User getReferencebyId(Long Id);

}