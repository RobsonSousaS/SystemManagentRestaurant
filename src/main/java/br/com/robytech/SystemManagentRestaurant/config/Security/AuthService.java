package br.com.robytech.SystemManagentRestaurant.config.Security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.robytech.SystemManagentRestaurant.models.User;
import br.com.robytech.SystemManagentRestaurant.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados invalidos ou incorretos!");
    }

}
