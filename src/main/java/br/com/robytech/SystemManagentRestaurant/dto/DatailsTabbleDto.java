package br.com.robytech.SystemManagentRestaurant.dto;

import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class DatailsTabbleDto {
    private long id;

    public DatailsTabbleDto(Tabble tabble) {
        this.id = tabble.getId();
    }

    public long getId() {
        return id;
    }
}
