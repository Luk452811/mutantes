package com.example.mutante.repositories;

import com.example.mutante.entities.Humano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanoRepository extends JpaRepository<Humano,Long> {
}
