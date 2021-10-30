package com.example.mutante.utils;

//En esta clase se encuentran los métodos de busqueda
public class Recorrer {

    public int Horizontal(char[][] dnaAnalyze, int contador) {

        if (contador == 2) {
            return contador;
        }
        buscar:
        for (int i = 0; i < dnaAnalyze.length; i++) {
            for (int j = 0; j < dnaAnalyze[i].length - 3; j++) {
                if (dnaAnalyze[i][j] == dnaAnalyze[i][j + 3]) {
                    if (dnaAnalyze[i][j] == dnaAnalyze[i][j + 2]) {
                        if (dnaAnalyze[i][j] == dnaAnalyze[i][j + 1]) {
                            contador++;
                        }
                    }
                }
                if (contador == 2) {
                    break buscar;
                }
            }
        }
        return contador;
    }

    public int Vertical(char[][] dnaAnalyze, int contador) {

        if (contador == 2) {
            return contador;
        }

        buscar:
        for (int i = 0; i < dnaAnalyze.length - 3; i++) {
            for (int j = 0; j < dnaAnalyze[i].length; j++) {
                if (dnaAnalyze[i][j] == dnaAnalyze[i + 3][j]){
                    if (dnaAnalyze[i][j] == dnaAnalyze[i + 2][j]){
                        if (dnaAnalyze[i][j] == dnaAnalyze[i + 1][j]){
                            contador++;
                        }
                    }
                }
                if (contador == 2) {
                    break buscar;
                }
            }
        }
        return contador;
    }

    public int Diagonal(char[][] dnaAnalyze, int contador) {

        if (contador == 2) {
            return contador;
        }

        buscar:
        for (int i = 0; i < dnaAnalyze.length - 3; i++) {
            for (int j = 0; j < dnaAnalyze[i].length - 3; j++) {
                if (dnaAnalyze[i][j] == dnaAnalyze[i + 3][j + 3]){
                    if (dnaAnalyze[i][j] == dnaAnalyze[i + 2][j + 2]){
                        if (dnaAnalyze[i][j] == dnaAnalyze[i + 1][j + 1]){
                            contador++;
                        }
                    }
                }
                if (contador == 2) {
                    break buscar;
                }
            }
        }
        return contador;
    }
    public int ContraDiagonal(char[][] dnaAnalyze, int contador) {

        if (contador == 2) {
            return contador;
        }
        buscar:
        for (int i = 3;  i < dnaAnalyze.length ; i++) {
            for (int j = 0; j < dnaAnalyze[i].length - 3; j++) {
                if (dnaAnalyze[i][j] == dnaAnalyze[i - 1][j + 1]){
                    if (dnaAnalyze[i][j] == dnaAnalyze[i - 2][j + 2]){
                        if (dnaAnalyze[i][j] == dnaAnalyze[i - 3][j + 3]){
                            contador++;
                        }
                    }
                }
                if (contador == 2) {
                    break buscar;
                }
            }
        }
        return contador;
    }
}



