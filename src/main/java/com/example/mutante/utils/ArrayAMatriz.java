package com.example.mutante.utils;

import com.example.mutante.entities.ADN;
import com.example.mutante.entities.Humano;

public class ArrayAMatriz {

    public static char[][] convertir(String[] dna1) {

        char[][] matrix = new char[dna1.length][dna1.length];
        for (int i = 0; i < dna1.length; i++) {
            for (int j = 0; j < dna1.length; j++) {
                matrix[i][j] = dna1[i].charAt(j);

            }

        }
        return matrix;
    }
}
