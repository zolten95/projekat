package com.example.projekat.service;

import com.example.projekat.model.Clan;

import java.util.List;

public interface ClanService {

     Clan findOne(String korisnicko_ime);

     List<Clan> findAll();


     Clan update(Clan clan) throws  Exception;

     void delete(Long id);

     Clan findByKimeandLozinka(String korisnicko_ime, String lozinka);


    Clan create(Clan clan) throws  Exception;

}
