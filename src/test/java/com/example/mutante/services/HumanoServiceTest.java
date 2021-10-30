package com.example.mutante.services;

import com.example.mutante.entities.Humano;
import com.example.mutante.repositories.HumanoRepository;
import com.example.mutante.utils.ArrayAMatriz;
import com.example.mutante.utils.Recorrer;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HumanoServiceTest {

    @MockBean
    private HumanoRepository humanoRepository;

    @Autowired
    private HumanoService humanoService;

    @Test
    public void findAllTest() throws Exception {
        Humano humano = new Humano();
        humano.setDna("ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG");
        humano.setId(1L);

        List<Humano> listaenviada = new ArrayList<>();
        listaenviada.add(humano);

        when(humanoRepository.findAll()).thenReturn(listaenviada);
        assertEquals(listaenviada,humanoService.findAll());
    }
    @Test
    public void findByIdTest() throws Exception {
        Humano humano = new Humano();
        humano.setDna("ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG");
        humano.setId(1l);
        when(humanoRepository.findById(1L)).thenReturn(java.util.Optional.of(humano));
        assertEquals(humano,humanoService.findById(1L));
    }

    @Test
    public void saveTest() throws Exception {
        Humano humano = new Humano();
        humano.setDna("AGGCGG GAGTGC TTATGG TGAATG CTCCTA TTACTG");

        when(humanoRepository.save(humano)).thenReturn(humano);
        assertEquals(humano,humanoService.save(humano));
    }

    @Test
    public void isMutantTest() throws Exception {
        String[] dna = {"ATGCGA","CACTGC","TCTTCG","CGACGG","CCCGTA","TCGCTG"};

       assertEquals(true,humanoService.isMutant(dna));

    }
    @Test
    public void isMutantTest2() throws Exception {
        String[] dna = {"ATGCGA",
                        "CACTGC",
                        "TCTTCG",
                        "CGATTG",
                        "CCCGTA",
                        "TCGCTG"};

        assertEquals(false,humanoService.isMutant(dna));

    }
}
