package com.example.mutante.entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Humano")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Humano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dna")
    private String dna;

    @Column(name = "isMutant")
    private boolean isMutant;

}
