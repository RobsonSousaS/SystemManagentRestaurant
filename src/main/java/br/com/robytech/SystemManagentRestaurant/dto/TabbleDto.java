package br.com.robytech.SystemManagentRestaurant.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.robytech.SystemManagentRestaurant.models.Tabble;

public class TabbleDto {
    private long id;

    public TabbleDto(Tabble tabble) {
        this.id = tabble.getId();
    }

    public long getId() {
        return id;
    }

    public static List<TabbleDto> converter(List<Tabble> tabble) {
        return tabble.stream().map(TabbleDto::new).collect(Collectors.toList());
    }
}
