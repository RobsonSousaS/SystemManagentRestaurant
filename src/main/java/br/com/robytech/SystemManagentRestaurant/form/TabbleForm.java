package br.com.robytech.SystemManagentRestaurant.form;

import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class TabbleForm {
    private long id;

    public long getId() {
        return id;
    }

    public Tabble converter(){
        return new Tabble(id, null, null);
    }
}
