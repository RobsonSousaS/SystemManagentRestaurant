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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.robytech.SystemManagentRestaurant.dto.UserDto;

import br.com.robytech.SystemManagentRestaurant.form.UpdateUserForm;
import br.com.robytech.SystemManagentRestaurant.form.UserForm;
import br.com.robytech.SystemManagentRestaurant.models.User;
import br.com.robytech.SystemManagentRestaurant.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserDto> getUserDtos() {
        List<User> user = userRepository.findAll();
        return UserDto.converter(user);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> CadasterUser(@RequestBody @Valid UserForm form,
            UriComponentsBuilder uriBuilder) {
        User user = form.converter();
        userRepository.save(user);
        URI uri = uriBuilder.path("/user/{email}").buildAndExpand(user.getEmail()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @PutMapping("/{email}")
    @Transactional
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserForm form) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = form.update(id, userRepository);
            return ResponseEntity.ok(new UserDto(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{email}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
