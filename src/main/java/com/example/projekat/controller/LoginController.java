package com.example.projekat.controller;

import com.example.projekat.model.Administrator;
import com.example.projekat.model.Clan;
import com.example.projekat.model.Trener;
import com.example.projekat.service.AdministratorService;
import com.example.projekat.service.ClanService;
import com.example.projekat.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    private final ClanService clanService;




    @Autowired
    public LoginController(ClanService clanService) {
        this.clanService = clanService;

    }


    @GetMapping(value = "/{kime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clan> getClan(@PathVariable("kime") String korisnicko_ime, @PathVariable("lozinka") String lozinka)
    {
        Clan clan = this.clanService.findByKimeandLozinka(korisnicko_ime,lozinka);

        if (clan == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clan,HttpStatus.OK);
    }



}
