package com.example.projekat.controller;

import com.example.projekat.model.DTO.FitnesCentarDTO;
import com.example.projekat.model.FitnesCentar;
import com.example.projekat.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fitnescentar")
public class FitnesCentarController {

    private final FitnesCentarService fitnesCentarService;

    @Autowired
    public FitnesCentarController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService = fitnesCentarService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> createFitnesCentar(@RequestBody FitnesCentarDTO fitnescentarDTO) throws Exception {

        FitnesCentar fitnescentar = new FitnesCentar(fitnescentarDTO.getId(),fitnescentarDTO.getNaziv(), fitnescentarDTO.getAdresa(),
                fitnescentarDTO.getBroj_telefona(), fitnescentarDTO.getEmail());

        FitnesCentar newFitnesscentar = fitnesCentarService.create(fitnescentar);

        FitnesCentarDTO newFitnessCentarDTO = new FitnesCentarDTO(newFitnesscentar.getId(), newFitnesscentar.getNaziv(),
                newFitnesscentar.getAdresa(), newFitnesscentar.getBr_telefona(), newFitnesscentar.getEmail());

        return new ResponseEntity<>(newFitnessCentarDTO, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDTO>> getCentar() {

        List<FitnesCentar> fitnescentarList = this.fitnesCentarService.findAll();


        List<FitnesCentarDTO> fitnescentriDTOS = new ArrayList<>();

        for (FitnesCentar fitnescentar : fitnescentarList) {

            FitnesCentarDTO fitnesscentarDTO = new FitnesCentarDTO(fitnescentar.getId(), fitnescentar.getNaziv(),
                    fitnescentar.getAdresa(), fitnescentar.getBr_telefona(),fitnescentar.getEmail());
            fitnescentriDTOS.add(fitnesscentarDTO);
        }

        return new ResponseEntity<>(fitnescentriDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCentar(@PathVariable Long id) {

        this.fitnesCentarService.delete(id);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> updateFitnessCentar(@PathVariable Long id, @RequestBody FitnesCentarDTO fitnescentarDTO) throws Exception {
        FitnesCentar fitnesscentar = new FitnesCentar(fitnescentarDTO.getId(), fitnescentarDTO.getNaziv(), fitnescentarDTO.getAdresa(),
                fitnescentarDTO.getBroj_telefona(), fitnescentarDTO.getEmail());

        fitnesscentar.setId(id);


        FitnesCentar updatedEm = fitnesCentarService.update(fitnesscentar);


        FitnesCentarDTO updatedEmDTO = new FitnesCentarDTO(updatedEm.getId(), updatedEm.getNaziv(),
                updatedEm.getAdresa(), updatedEm.getBr_telefona(), updatedEm.getEmail());


        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
    }


}
