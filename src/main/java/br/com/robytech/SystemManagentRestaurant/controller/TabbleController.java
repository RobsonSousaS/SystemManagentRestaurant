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

import br.com.robytech.SystemManagentRestaurant.dto.DatailsTabbleDto;
import br.com.robytech.SystemManagentRestaurant.dto.TabbleDto;
import br.com.robytech.SystemManagentRestaurant.form.TabbleForm;
import br.com.robytech.SystemManagentRestaurant.form.UpdateTabbleForm;
import br.com.robytech.SystemManagentRestaurant.models.Tabble;

import br.com.robytech.SystemManagentRestaurant.repository.TabbleRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/table")
@Validated
public class TabbleController {

    @Autowired
    private TabbleRepository tabbleRepository;

    @GetMapping
    public List<TabbleDto> getTabble() {
        List<Tabble> tabble = tabbleRepository.findAll();
        return TabbleDto.converter(tabble);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TabbleDto> CadasterTabble(@RequestBody @Valid TabbleForm form,
            UriComponentsBuilder uriBuilder) {
        Tabble tabble = form.converter();
        tabbleRepository.save(tabble);
        URI uri = uriBuilder.path("/table/{id}").buildAndExpand(tabble.getId()).toUri();
        return ResponseEntity.created(uri).body(new TabbleDto(tabble));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatailsTabbleDto> detailsTabble(@PathVariable Long id) {
        Optional<Tabble> tabble = tabbleRepository.findById(id);
        if (tabble.isPresent()) {
            return ResponseEntity.ok(new DatailsTabbleDto(tabble.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TabbleDto> updateClient(@PathVariable Long id, @RequestBody @Valid UpdateTabbleForm form) {
        Optional<Tabble> optional = tabbleRepository.findById(id);
        if (optional.isPresent()) {
            Tabble tabble = form.update(id, tabbleRepository);
            return ResponseEntity.ok(new TabbleDto(tabble));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Optional<Tabble> optional = tabbleRepository.findById(id);
        if (optional.isPresent()) {
            tabbleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
