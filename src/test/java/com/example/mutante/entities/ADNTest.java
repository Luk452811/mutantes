package com.example.mutante.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ADNTest {

    @Test
    public void ADN (){
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        ADN adn = new ADN();

        ADN adn1 = new ADN(dna);

        adn1.getDna();
    }
}
