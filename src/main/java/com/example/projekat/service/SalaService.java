package com.example.projekat.service;

import com.example.projekat.model.Sala;

import java.util.List;

public interface SalaService {



    List<Sala> findAll();

    Sala create(Sala sala) throws Exception;

    Sala update(Sala sala) throws Exception;

    void delete(Long id);

    Sala nadjiOznaka(int oznaka);


}
