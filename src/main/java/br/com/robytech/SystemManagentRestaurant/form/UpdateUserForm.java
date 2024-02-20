package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.User;
import br.com.robytech.SystemManagentRestaurant.repository.UserRepository;

public class UpdateUserForm {
    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User update(Long id, UserRepository userRepository) {
        User user = userRepository.getReferenceById(id);
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setPass(this.getPassword());
        return user;
    }

}
