package com.example.mutante.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HumanoTest {

    @Test
    public void Humano(){
        Long id=12L;
        String dna = "AGGCGG GAGTGC TTATGG TGAATG CTCCTA TTACTG";
        boolean mutant=true;
        Humano humano =new Humano(id,dna,mutant);
        System.out.println("Humano con DNA= "+ humano.getDna()+" y con id= "+humano.getId()+"es mutante? "+ mutant);
    }
}
