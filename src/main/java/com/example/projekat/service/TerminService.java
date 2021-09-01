package com.example.projekat.service;

import com.example.projekat.model.Termin;

import java.util.List;

public interface TerminService {
    Termin findOne(Long id);

    List<Termin> findAll();

    Termin create(Termin termin) throws Exception;

    Termin update(Termin termin) throws Exception;

    void delete(Long id);

    List<Termin> nadjiSortirane(Long id);

    Termin nadjiFitnesCentarTermin(Long id);

    Termin nadjiSalaTermin(Long id);


}
