package com.example.projekat.service.impl;

import com.example.projekat.model.Trening;
import com.example.projekat.repository.TreningRepository;
import com.example.projekat.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningServiceimpl implements TreningService {

    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceimpl(TreningRepository treningRepository) {
        super();
        this.treningRepository = treningRepository;
    }

    @Override
    public Trening findOne(Long id) {
        Trening trening = this.treningRepository.getOne(id);
        return trening;

    }

    @Override
    public List<Trening> findAll() {
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }

    @Override
    public Trening create(Trening trening) throws Exception {
        if (trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trening newTrening = this.treningRepository.save(trening);
        return newTrening;
    }

    @Override
    public Trening update(Trening trening) throws Exception {
        Trening treningToUpdate = this.treningRepository.getOne(trening.getId());
        if (treningToUpdate == null) {
            throw new Exception("Trening ne postoji");
        }

        treningToUpdate.setNaziv(trening.getNaziv());
        treningToUpdate.setOpis(trening.getOpis());
        treningToUpdate.setTrajanje(trening.getTrajanje());
        treningToUpdate.setTip(trening.getTip());
        treningToUpdate.setCena(trening.getCena());

        Trening savedEm = this.treningRepository.save(treningToUpdate);
        return savedEm;

    }

    @Override
    public void delete(Long id) {
        this.treningRepository.deleteById(id);

    }

    @Override
    public List<Trening> sortTreningByCena() {
        List<Trening> sorted = treningRepository.findByOrderByCenaAsc();
        if (sorted == null) {
            return null;
        }
        return sorted;
    }

    @Override
    public List<Trening> findBynaziv(String naziv) {
        List<Trening > poNazivima = this.treningRepository.findByNaziv(naziv);
        if(poNazivima == null)
        {
            return null;
        }
        return poNazivima;

    }

    @Override
    public List<Trening> findCena(Double cena) {
        List<Trening> trening = this.treningRepository.findByCena(cena);
        if(trening == null) {
            return null;
        }
        return trening;
    }

    @Override
    public List<Trening> findOpis(String opis) {
        List<Trening> trening = this.treningRepository.findByOpis(opis);
        if(trening == null) {
            return null;
        }
        return trening;
    }
    @Override
    public Trening pronadji(String naziv) {
        return this.treningRepository.nadjiNazi(naziv);

    }


}
