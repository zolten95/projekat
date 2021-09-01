package com.example.projekat.controller;
import com.example.projekat.model.Clan;
import com.example.projekat.model.DTO.ClanDTO;
import com.example.projekat.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping (value = "api/clan")
public class ClanController {

    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> dodajClana(@RequestBody ClanDTO clanDTO ) throws Exception
    {
        Clan clan = new Clan(clanDTO.getIme(),clanDTO.getPrezime(),clanDTO.getDatum_rodjenja(),clanDTO.getKorisnicko_ime(),clanDTO.getLozinka(),clanDTO.getKontakt(),clanDTO.getEmail(),clanDTO.getUloga());
        Clan noviClan = clanService.create(clan);
        ClanDTO noviClanDTO = new ClanDTO(noviClan.getId(),noviClan.getKorisnicko_ime(),noviClan.getLozinka(),noviClan.getIme(),noviClan.getPrezime(),noviClan.getKontakt(),noviClan.getEmail(),noviClan.getDatum_rodjenja(),noviClan.getUloga());
        return new ResponseEntity<>(noviClanDTO,HttpStatus.CREATED);

    }
    @GetMapping(value = "/prikazi/{korisnicko_ime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClann(@PathVariable("korisnicko_ime") String korisnicko_ime) {

        Clan clan = this.clanService.findOne(korisnicko_ime);


        ClanDTO clanDTO = new ClanDTO();
        clanDTO.setKorisnicko_ime(clan.getKorisnicko_ime());
        clanDTO.setIme(clan.getIme());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setLozinka(clan.getLozinka());
        clanDTO.setKontakt(clan.getKontakt());
        clanDTO.setEmail(clan.getEmail());
        clanDTO.setDatum_rodjenja(clan.getDatum_rodjenja());


        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }





}
