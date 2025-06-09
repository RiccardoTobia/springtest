package org.zefiro.dbInit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.zefiro.dbInit.models.Animale;
import org.zefiro.dbInit.repo.AnimaleRepo;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource("classpath:test.properties")
class AnimaleJpaTestCase {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnimaleRepo animaleRepository;

    @BeforeEach
    void setUp() {
        // Inizializzazione dati di test programmaticamente
        Animale utente1 = new Animale();
        utente1.setNome("Scooby-Doo");
        utente1.setSpecie("Cane");
        utente1.setColore("Marrone");
        
        Animale utente2 = new Animale();
        utente2.setNome("Hamtaro");
        utente2.setSpecie("Criceto");
        utente2.setColore("Bianco e arancione");

        entityManager.persistAndFlush(utente1);
        entityManager.persistAndFlush(utente2);
    }

    @Test
    void testFindByNome() {
        // Test del metodo findByEmail
        Optional<Animale> utente = animaleRepository.findByNome("Hamtaro");
        
        assertThat(utente).isPresent();
        assertThat(utente.get().getNome()).isEqualTo("Hamtaro");
        assertThat(utente.get().getSpecie()).isEqualTo("Criceto");
    }

//    @Test
//    void testFindByEtaGreaterThan() {
//        // Test di una query personalizzata
//        List<Animale> utenti = animaleRepository.findByEtaGreaterThan(28);
//        
//        assertThat(utenti).hasSize(1);
//        assertThat(utenti.get(0).getNome()).isEqualTo("Mario Rossi");
//    }

    @Test
    void testSaveUtente() {
        // Test di salvataggio
        Animale nuovoUtente = new Animale();
        nuovoUtente.setNome("Chopper");
        nuovoUtente.setSpecie("Renna");
        nuovoUtente.setColore("Marrone");

        Animale utenteSalvato = animaleRepository.save(nuovoUtente);

        assertThat(utenteSalvato.getId()).isNotNull();
        assertThat(utenteSalvato.getNome()).isEqualTo("Chopper");
    }

    @Test
    void testDeleteUtente() {
        // Test di eliminazione
        Optional<Animale> utente = animaleRepository.findByNome("Scooby-Doo");
        assertThat(utente).isPresent();

        animaleRepository.delete(utente.get());

        Optional<Animale> utenteEliminato = animaleRepository.findByNome("Scooby-Doo");
        assertThat(utenteEliminato).isEmpty();
    }

}
