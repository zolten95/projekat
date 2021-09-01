package com.example.projekat.controller;


import com.example.projekat.model.DTO.FitnesCentarDTO;
import com.example.projekat.model.DTO.SalaDTO;
import com.example.projekat.model.FitnesCentar;
import com.example.projekat.model.Sala;
import com.example.projekat.model.Trener;
import com.example.projekat.service.FitnesCentarService;
import com.example.projekat.service.SalaService;
import com.example.projekat.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SalaController {


    private final SalaService salaService;
    private final FitnesCentarService fitnescentarService;
    private final TrenerService trenerService;


    public SalaController(SalaService salaService, FitnesCentarService fitnescentarService, TrenerService trenerService) {
        this.salaService = salaService;
        this.fitnescentarService = fitnescentarService;
        this.trenerService = trenerService;
    }




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale() {

        List<Sala> salaList = this.salaService.findAll();

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala : salaList) {

            FitnesCentarDTO fitnes = new FitnesCentarDTO();
            fitnes.setId(sala.getFitnes_centar().getId());
            fitnes.setNaziv(sala.getFitnes_centar().getNaziv());


            SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka());
            salaDTO.setFitnessCentar(fitnes);
            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {

        this.salaService.delete(id);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO, @PathVariable String id) throws Exception {

        FitnesCentar fitnes = fitnescentarService.nadji(id);

        Sala sala = new Sala(salaDTO.getId() ,salaDTO.getKapacitet(), salaDTO.getOznaka());
        sala.setFitnes_centar(fitnes);



        Sala newSala = salaService.create(sala);


        SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getKapacitet(),
                newSala.getOznaka());


        return new ResponseEntity<>(newSalaDTO,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception {


        Sala sala = new Sala(salaDTO.getId(), salaDTO.getKapacitet(), salaDTO.getOznaka());
        sala.setId(id);
        Sala updatedEm = salaService.update(sala);
        SalaDTO updatedEmDTO = new SalaDTO(updatedEm.getId(), updatedEm.getKapacitet(),
                updatedEm.getOznaka());

        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
    }




}
