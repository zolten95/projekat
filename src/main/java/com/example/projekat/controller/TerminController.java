package com.example.projekat.controller;


import com.example.projekat.model.DTO.SalaDTO;
import com.example.projekat.model.DTO.TerminDTO;
import com.example.projekat.model.DTO.TreningDTO;
import com.example.projekat.model.Sala;
import com.example.projekat.model.Termin;
import com.example.projekat.model.Trening;
import com.example.projekat.service.ClanService;
import com.example.projekat.service.SalaService;
import com.example.projekat.service.TerminService;
import com.example.projekat.service.TreningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/termin")
public class TerminController {


    private final TerminService terminService;
    private final SalaService salaService;
    private final TreningService treningService;
    private final ClanService clanService;


    public TerminController(TerminService terminService, SalaService salaService, TreningService treningService, ClanService clanService) {
        this.terminService = terminService;
        this.salaService = salaService;
        this.treningService = treningService;
        this.clanService = clanService;
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermin() {

        List<Termin> terminList = this.terminService.findAll();


        List<TerminDTO> terminiDTOS = new ArrayList<>();

        for (Termin termin : terminList) {

            SalaDTO sala= new SalaDTO();
            sala.setId(termin.getSala().getId());
            sala.setOznaka(termin.getSala().getOznaka());
            TreningDTO trening=new TreningDTO();
            trening.setId(termin.getTrening().getId());
            trening.setNaziv(termin.getTrening().getNaziv());
            trening.setCena(termin.getTrening().getCena());

            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getDatum());

            terminDTO.setSala(sala);
            terminDTO.setTrening(trening);
            terminiDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO) throws Exception {

        Trening t=treningService.pronadji(terminDTO.getTrening().getNaziv());
        Sala s = salaService.nadjiOznaka(terminDTO.getSala().getOznaka());

        Termin termin = new Termin(terminDTO.getId(),terminDTO.getDatum() );
        termin.setTrening(t);
        termin.setSala(s);

        Termin newTermin = terminService.create(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(), newTermin.getDatum());



        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCentar(@PathVariable Long id) {
        System.out.println(id);
        this.terminService.delete(id);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
