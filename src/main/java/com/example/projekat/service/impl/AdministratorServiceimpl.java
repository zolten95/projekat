package com.example.projekat.service.impl;

import com.example.projekat.model.Administrator;
import com.example.projekat.repository.AdministratorRepository;
import com.example.projekat.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceimpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceimpl(AdministratorRepository administratorRepository)
    {
        super();
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator findOne(Long id)
    {
        Administrator administrator = this.administratorRepository.getOne(id);
        return administrator;
    }

    @Override
    public List<Administrator> findAll()
    {
        List<Administrator> administrators = this.administratorRepository.findAll();
        return administrators;
    }
    @Override
    public Administrator create(Administrator administrator) throws Exception
    {
        Administrator newAdministrator = this.administratorRepository.save(administrator);
        return newAdministrator;
    }

    @Override
    public void delete(Long id)
    {
        this.administratorRepository.deleteById(id);
    }

    @Override
    public Administrator findByKimeandLozinka(String korisnicko_ime, String lozinka)
    {
        Administrator administrator = this.administratorRepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
        return administrator;
    }

}
