package com.example.projekat.service;

import com.example.projekat.model.Administrator;
import com.example.projekat.model.Clan;

import java.util.List;

public interface AdministratorService {

    Administrator findOne(Long id);

    List<Administrator> findAll();

    Administrator create(Administrator administrator) throws Exception;



    void delete(Long id);

    Administrator findByKimeandLozinka(String korisnicko_ime, String lozinka);
}
