package com.example.mutante.utils;

import com.example.mutante.utils.Recorrer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecorrerTest {

    char[][] dna = {{'A','T','G','C','G','A'},{'C','A','G','T','G','C'},
            {'T','T','A','T','G','T'},{'A','G','A','A','G','G'},
            {'C','C','C','C','T','A'},{'T','C','A','C','T','G'}};
    Recorrer recorrer = new Recorrer();
    @Test
    public void HorizontalTest(){
        char[][] dna = {{'A','T','G','C','G','A'},{'C','A','G','T','G','C'},
                {'T','T','T','T','G','T'},{'A','G','A','A','G','G'},
                {'C','C','C','C','T','A'},{'T','C','A','C','T','G'}};

        int Contador=recorrer.Horizontal(dna,0);
        assertEquals(Contador,2);
        System.out.println("se encontraron "+Contador +" coincidencia/s");

    }
    @Test
    public void HorizontalTest2(){


        int contador=recorrer.Horizontal(dna,2);
        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
    @Test
    public void VericalTest(){
        char[][] dna = {{'A','T','G','C','G','A'},{'A','A','G','T','G','C'},
                {'A','T','A','T','G','T'},{'A','G','A','A','G','G'},
                {'C','C','C','C','T','A'},{'T','C','A','C','T','G'}};

        int contador=recorrer.Vertical(dna,0);

        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }

    @Test
    public void VericalTest2(){

        int contador=recorrer.Vertical(dna,2);
        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
    @Test
    public void DiagonalTest(){
        char[][] dna = {{'A','G','G','C','G','A'},{'C','A','G','T','G','C'},
                {'T','T','A','G','G','T'},{'A','G','A','A','G','G'},
                {'C','C','C','C','T','A'},{'T','C','A','C','T','G'}};
        int contador=recorrer.Diagonal(dna,0);

        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
    @Test
    public void DiagonalTest2(){

        int contador=recorrer.Diagonal(dna,2);
        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
    @Test
    public void ContraDiagonalTest(){
        char[][] dna = {{'A','T','G','C','G','A'},{'C','A','C','T','G','C'},
                {'T','C','A','T','G','G'},{'C','G','A','A','G','G'},
                {'C','C','C','G','T','A'},{'T','C','G','C','T','G'}};
        int contador=recorrer.ContraDiagonal(dna,0);

        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
    @Test
    public void ContraDiagonalTest2(){

        int contador=recorrer.ContraDiagonal(dna,2);
        assertEquals(contador,2);
        System.out.println("se encontraron "+contador +" coincidencia/s");

    }
}
