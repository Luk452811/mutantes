package com.example.mutante.utils;

import com.example.mutante.utils.ArrayAMatriz;
import org.junit.jupiter.api.Test;

public class ArrayAMatrizTest {

    @Test
    public void convertirTest() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        ArrayAMatriz arrayAMatriz = new ArrayAMatriz();
        char[][] dnaMatriz = arrayAMatriz.convertir(dna);


        for (int i = 0; i < dna.length; i++) {    // El primer índice recorre las filas.
            for (int j = 0; j < dna.length; j++) {    // El segundo índice recorre las columnas.
                // Procesamos cada elemento de la matriz.
                System.out.println(dnaMatriz[i][j]);
            }
            System.out.println();
        }
    }
}
