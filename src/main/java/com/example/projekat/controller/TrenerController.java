package com.example.projekat.controller;

import com.example.projekat.model.Clan;
import com.example.projekat.model.DTO.ClanDTO;
import com.example.projekat.model.DTO.TrenerDTO;
import com.example.projekat.model.Trener;
import com.example.projekat.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treneri")
public class TrenerController {

    private final TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService = trenerService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> dodajTrenera(@RequestBody TrenerDTO trenerDTO) throws  Exception
    {
        Trener trener = new Trener(trenerDTO.getIme(),trenerDTO.getPrezime(),trenerDTO.getDatum_rodjenja(),trenerDTO.getKorisnicko_ime(),trenerDTO.getLozinka(),trenerDTO.getKontakt(),trenerDTO.getEmail(),trenerDTO.isObrisan(), trenerDTO.isAktivan());
        trener.setObrisan(false);
        trener.setAktivan(true);
        trener.setUloga("trener");
        Trener noviTrener = trenerService.create(trener);
        TrenerDTO noviTrenerDTO = new TrenerDTO(noviTrener.getId(),noviTrener.getKorisnicko_ime(),noviTrener.getLozinka(),noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getKontakt(),noviTrener.getEmail(),noviTrener.getDatum_rodjenja(),noviTrener.isObrisan(),noviTrener.isAktivan());
        return new ResponseEntity<>(noviTrenerDTO,HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTrener() {

        List<Trener> trenerList = this.trenerService.findAll();


        List<TrenerDTO> treneriDTOS = new ArrayList<>();

        for (Trener trener: trenerList) {
            if(!trener.isObrisan()) {
                TrenerDTO trenerDTO = new TrenerDTO( trener.getId(),trener.getKorisnicko_ime(),
                        trener.getLozinka(), trener.getIme(),trener.getPrezime(),trener.getKontakt(), trener.getEmail(),trener.getDatum_rodjenja(), trener.isObrisan(),trener.isAktivan());
                treneriDTOS.add(trenerDTO);
            }
        }

        return new ResponseEntity<>(treneriDTOS, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println(id);
        this.trenerService.delete(id);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
