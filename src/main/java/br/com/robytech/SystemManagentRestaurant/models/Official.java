package br.com.robytech.SystemManagentRestaurant.models;

import br.com.robytech.SystemManagentRestaurant.models.enums.StatusOfficialEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Official {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    private String Office;
    @Enumerated(EnumType.STRING)
    private StatusOfficialEnum statusOfficial = StatusOfficialEnum.ACTIVE;

    public Official(Long id, String name, String contact, String office, StatusOfficialEnum statusOfficial) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        Office = office;
        this.statusOfficial = statusOfficial;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }

    public StatusOfficialEnum getStatusOfficial() {
        return statusOfficial;
    }

    public void setStatusOfficial(StatusOfficialEnum statusOfficial) {
        this.statusOfficial = statusOfficial;
    }

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
