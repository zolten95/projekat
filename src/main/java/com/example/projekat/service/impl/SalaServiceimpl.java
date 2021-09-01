package com.example.projekat.service.impl;

import com.example.projekat.model.Sala;
import com.example.projekat.repository.SalaRepository;
import com.example.projekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalaServiceimpl implements SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceimpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }


    @Override
    public List<Sala> findAll() {
        List<Sala> sala = this.salaRepository.findAll();
        return sala;

    }

    @Override
    public Sala create(Sala sala) throws Exception {
        if (sala.getId() != null) {
            throw new Exception("ID mora biti null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;

    }

    @Override
    public Sala update(Sala sala) throws Exception {
        Sala salazaUpdate = this.salaRepository.getOne(sala.getId());
        if (salazaUpdate == null) {
            throw new Exception("Sala ne postoji!");
        }


        salazaUpdate.setKapacitet(sala.getKapacitet());
        salazaUpdate.setOznaka(sala.getOznaka());


        Sala sacuvana = this.salaRepository.save(salazaUpdate);
        return sacuvana;
    }

    @Override
    public void delete(Long id) {

        this.salaRepository.deleteById(id);

    }
    @Override
    public Sala nadjiOznaka(int oznaka)
    {
        return this.salaRepository.nadjiSalaOznaka(oznaka);
    }


}
