package com.example.projekat.service.impl;

import com.example.projekat.model.Termin;
import com.example.projekat.repository.TerminRepository;
import com.example.projekat.service.TerminService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TerminServiceimpl implements TerminService {

    private final TerminRepository terminRepository;

    public TerminServiceimpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }


    @Override
    public Termin findOne(Long id) {
        Termin termin = this.terminRepository.getOne(id);
        return termin;
    }

    @Override
    public List<Termin> findAll() {
        List<Termin> termini = this.terminRepository.findAll();
        return termini;
    }

    @Override
    public Termin create(Termin termin) throws Exception {
        if (termin.getId() != null) {
            throw new Exception("ID mora biti null!");
        }
        Termin newTermin = this.terminRepository.save(termin);
        return newTermin;
    }

    @Override
    public Termin update(Termin termin) throws Exception {
        Termin terminToUpdate = this.terminRepository.getOne(termin.getId());
        if (terminToUpdate == null) {
            throw new Exception("Termin ne postoji");
        }

        terminToUpdate.setDatum(termin.getDatum());
        Termin sacuvan = this.terminRepository.save(terminToUpdate);
        return sacuvan;
    }

    @Override
    public void delete(Long id) {
        this.terminRepository.deleteById(id);
    }

    @Override
    public List<Termin> nadjiSortirane(Long id) {
        List<Termin> termins = this.terminRepository.nadjisortirane(id);
        if(termins == null) {
            return null;
        }
        return termins;
    }

    @Override
    public Termin nadjiFitnesCentarTermin(Long id) {
        Termin termin = this.terminRepository.nadjiTerminFitnesCentar(id);
        if( termin == null) {
            return null;
        }
        return termin;
    }

    @Override
    public Termin nadjiSalaTermin(Long id) {
        Termin termin = this.terminRepository.nadjiTerminSaTreningom(id);
        if( termin == null) {
            return null;
        }
        return termin;
    }
}
