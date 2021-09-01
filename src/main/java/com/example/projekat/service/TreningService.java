package com.example.projekat.service;

import com.example.projekat.model.Trening;

import java.util.List;

public interface TreningService {

    Trening findOne(Long id);

    List<Trening> findAll();

    Trening create(Trening trening) throws Exception;

    Trening update(Trening trening) throws Exception;

    void delete(Long id);

    List<Trening> sortTreningByCena();

    List<Trening> findBynaziv(String naziv);

    List<Trening> findCena(Double cena);

    List<Trening> findOpis(String opis);

    Trening pronadji(String naziv);


}
