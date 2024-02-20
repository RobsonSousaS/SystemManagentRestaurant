package br.com.robytech.SystemManagentRestaurant.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.robytech.SystemManagentRestaurant.models.Tabble;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TabbleRepositoryTest {

    @Autowired
    private TabbleRepository repository;

    @Test
    public void deveEncontrarUmaMesaPeloSeuId() {
        Long id = 1L;
        Tabble tabble = repository.getReferenceById(id);
        Assert.assertNotNull(tabble);
        Assert.assertEquals(id, tabble.getId());
    }

    @Test
    public void naoDeveEncontrarUmaMesaPeloSeuId() {
        Long id = 2L;
        Tabble tabble = repository.getReferenceById(id);
        Assert.assertNull(tabble);
    }

    @Test
    public void deveSalvarNovaMesa() {
        Tabble tabble = new Tabble();
        tabble.setNumero("1");

        Tabble savedTabble = repository.save(tabble);

        Assert.assertNotNull(savedTabble.getId());
        Assert.assertEquals(tabble.getNumero(), savedTabble.getNumero());
    }

    @Test
    public void deveAtualizarMesaExistente() {
        Long id = 1L;
        Tabble tabble = repository.findById(id).orElse(null);
        assertNotNull(tabble);

        String novoNumero = "6";
        tabble.setNumero(novoNumero);

        repository.save(tabble);

        Tabble updatedTabble = repository.findById(id).orElse(null);
        assertNotNull(updatedTabble);
        assertEquals(novoNumero, updatedTabble.getNumero());
    }

    @Test
    public void deveExcluirMesaExistente() {
        Long id = 1L;

        assertTrue(repository.existsById(id));

        repository.deleteById(id);

        assertFalse(repository.existsById(id));
    }

    @Test
    public void deveBuscarTodasAsMesas() {
        List<Tabble> allTabbles = repository.findAll();

        Assert.assertFalse(allTabbles.isEmpty());
        Assert.assertEquals(1, allTabbles.size());
                                                                    
    }

}
