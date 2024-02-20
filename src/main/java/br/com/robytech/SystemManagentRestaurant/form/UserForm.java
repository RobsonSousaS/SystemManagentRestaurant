package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.User;

public class UserForm {
    private Long id;
    private String name;
    private String email;
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User converter() {
        return new User(name, email, pass);
    }

}
