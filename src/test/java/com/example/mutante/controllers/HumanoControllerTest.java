package com.example.mutante.controllers;

import com.example.mutante.entities.Humano;
import com.example.mutante.repositories.HumanoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HumanoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private HumanoRepository humanoRepository;

    @Test
    public void findAllTest() throws Exception {

        humanoRepository.findAll();
        mockMvc.perform(get("/api/v1/humano")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    public void findByIdTest() throws Exception {

        humanoRepository.findById(33L);
        mockMvc.perform(get("/api/v1/humano/33")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void findByIdTest2() throws Exception {

        humanoRepository.findById(15L);
        mockMvc.perform(get("/api/v1/humano/15")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void saveTest() throws Exception {
        Humano humano = new Humano();
        humano.setDna("AGGCGG GAGTGC TTATGG TGAATG CTCATA TTACTG");

       humanoRepository.save(humano);
       mockMvc.perform(post("/api/v1/humano").content("{\"dna\": \"AGGCGG GAGTGC TTATGG TGAATG CTCCTA TTACTG\"}")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }



    @Test
    public void deleteTest() throws Exception {

        mockMvc.perform(delete("/api/v1/humano/15")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void isMutantTest() throws Exception {

        mockMvc.perform(post("/api/v1/humano/mutant").content("{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void isMutantTest2() throws Exception {

        mockMvc.perform(post("/api/v1/humano/mutant").content("{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGATTG\",\"CCCGTA\",\"TCACTG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
