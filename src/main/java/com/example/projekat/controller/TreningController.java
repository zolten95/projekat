package com.example.projekat.controller;


import com.example.projekat.model.DTO.FitnesCentarDTO;
import com.example.projekat.model.DTO.SalaDTO;
import com.example.projekat.model.DTO.TreningDTO;
import com.example.projekat.model.Sala;
import com.example.projekat.model.Trening;
import com.example.projekat.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/profil")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService) {
        super();
        this.treningService = treningService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> getTreninzi() {
        List<Trening> treninzi = this.treningService.findAll();

        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }

    @GetMapping(value = "/sortCena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> getSortirani() {
        List<Trening> treninzi = this.treningService.sortTreningByCena();

        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }

    @GetMapping(value = "/pretraga/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> nadjiTrening(@PathVariable("naziv") String naziv) {
        List<Trening> treninzi = this.treningService.findBynaziv(naziv);

        if (treninzi.size() == 0) {
            treninzi = this.treningService.findOpis(naziv);


            if (treninzi.size() == 0) {
                treninzi = this.treningService.findCena(Double.parseDouble(naziv));


                if (treninzi.size() == 0) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }

        }
        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }
}





