package com.example.projekat.controller;

import com.example.projekat.model.Clan;
import com.example.projekat.model.Trener;
import com.example.projekat.service.ClanService;
import com.example.projekat.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/login1")
public class LoginController1 {

    private final TrenerService trenerService;




    @Autowired
    public LoginController1(TrenerService trenerService) {
        this.trenerService = trenerService;

    }


    @GetMapping(value = "/{kime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trener> getTrener(@PathVariable("kime") String korisnicko_ime, @PathVariable("lozinka") String lozinka)
    {
        Trener trener = this.trenerService.findByKimeandLozinka(korisnicko_ime,lozinka);

        if (trener == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trener,HttpStatus.OK);
    }

}
