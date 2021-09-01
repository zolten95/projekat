package com.example.projekat.service;


import com.example.projekat.model.Clan;
import com.example.projekat.model.Trener;

import java.util.List;

public interface TrenerService {

    Trener findOne(Long id);

    List<Trener> findAll();


    Trener update(Trener trener) throws  Exception;

    void delete(Long id);

    Trener findByKimeandLozinka(String korisnicko_ime, String lozinka);


    Trener create(Trener trener) throws  Exception;

    List<Trener> findTrenerNeAktivan();

    Trener pronadji(Long id);
}
