package com.example.mutante.services;

import com.example.mutante.entities.ADN;
import com.example.mutante.entities.Humano;
import com.example.mutante.repositories.HumanoRepository;
import com.example.mutante.utils.ArrayAMatriz;
import com.example.mutante.utils.Recorrer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HumanoService implements BaseService<Humano> {

    private HumanoRepository humanoRepository;

    public HumanoService(HumanoRepository humanoRepository) {
        this.humanoRepository = humanoRepository;
    }

    @Override
    @Transactional
    public List<Humano> findAll() throws Exception {
        try {
            List<Humano> entities = humanoRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Humano findById(Long id) throws Exception {
        try {
            Optional<Humano> entityOptional = humanoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Humano save(Humano entity) throws Exception {
        try {
            entity = humanoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Humano update(Long id, Humano entity) throws Exception {
        try {
            Optional<Humano> entityOptional = humanoRepository.findById(id);
            Humano humano = entityOptional.get();
            humano = humanoRepository.save(humano);
            return humano;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (humanoRepository.existsById(id)) {
                humanoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean isMutant(String[] dna) throws Exception {

        try {
            Humano humano= new Humano();
            //llamamos al método "convertir" para trabajar el arreglo como matriz y lo alojamos en una variable
            char dna3[][] = ArrayAMatriz.convertir(dna);

            StringBuffer cadena = new StringBuffer();

            for (int x=0;x<dna.length;x++){
                cadena =cadena.append(dna[x]);
                cadena=cadena.append(" ");
            }

            //Instanciamos "Recorrer" para poder realizar las búsquedas
            Recorrer Recorrido = new Recorrer();

            //comenzamos la búsqueda con el recorrido horizontal, el método nos devuelve el contador, si este es igual a 2 se trata de un mutante
            int contador = 0;
            contador = Recorrido.Horizontal(dna3, contador);
            contador = Recorrido.Vertical(dna3, contador);
            contador = Recorrido.Diagonal(dna3, contador);
            contador = Recorrido.ContraDiagonal(dna3, contador);

            if (contador == 2) {
                humano.setMutant(true);
                humano.setDna(cadena.toString());
                humanoRepository.save(humano);
                return true;
            }
            humano.setMutant(false);
            humano.setDna(cadena.toString());
            humanoRepository.save(humano);
            return false;
        } catch (Exception e) {
        throw new Exception(e.getMessage());
    }

    }
}


