package com.example.mutante.entities;


import java.io.Serializable;


public class ADN implements Serializable {

    private String[] dna;

    public ADN() {

    }
    public ADN(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

}
