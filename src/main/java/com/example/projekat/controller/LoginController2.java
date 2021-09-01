package com.example.projekat.controller;

import com.example.projekat.model.Administrator;
import com.example.projekat.model.Trener;
import com.example.projekat.service.AdministratorService;
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
@RequestMapping(value = "/api/login2")
public class LoginController2 {

    private final AdministratorService administratorService;




    @Autowired
    public LoginController2(AdministratorService administratorService) {
        this.administratorService = administratorService;

    }


    @GetMapping(value = "/{kime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrator> getAdmin(@PathVariable("kime") String korisnicko_ime, @PathVariable("lozinka") String lozinka)
    {
        Administrator administrator = this.administratorService.findByKimeandLozinka(korisnicko_ime,lozinka);

        if (administrator == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(administrator,HttpStatus.OK);
    }

}
