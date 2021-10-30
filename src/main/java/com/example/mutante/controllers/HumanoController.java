package com.example.mutante.controllers;

import com.example.mutante.entities.ADN;
import com.example.mutante.entities.Humano;
import com.example.mutante.services.HumanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping(path = "api/v1/humano")
public class HumanoController {
    private HumanoService humanoService;

    public HumanoController(HumanoService humanoService) {
        this.humanoService = humanoService;
    }
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findAll());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Humano entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Humano entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(humanoService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");
        }
    }
    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody ADN entity) {

        try {
            String dna1[]= entity.getDna();
            if (humanoService.isMutant(dna1)){
                return ResponseEntity.status(HttpStatus.OK).body("Mutante");}
            else{
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es mutante");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\";\"Error, Por Favor Intente Mas Tarde.\"}");
        }
        }
    }
