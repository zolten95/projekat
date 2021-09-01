package com.example.projekat.service.impl;

import com.example.projekat.model.Clan;
import com.example.projekat.model.Trener;
import com.example.projekat.repository.TrenerRepository;
import com.example.projekat.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerServiceimpl implements TrenerService {

    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceimpl(TrenerRepository trenerRepository) {
        this.trenerRepository = trenerRepository;
    }


    @Override
    public Trener findOne(Long id)
    {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }

    @Override
    public List<Trener> findAll()
    {
        List<Trener> treneri = this.trenerRepository.findAll();
        return treneri;
    }

    @Override
    public Trener update(Trener trener) throws Exception {
        Trener trenerZaupdate = this.trenerRepository.getOne(trener.getId());
        if(trenerZaupdate == null)
        {
            throw new Exception( "Trener ne postoji");
        }
        trenerZaupdate.setAktivan(trener.isAktivan());

        Trener sacuvan = this.trenerRepository.save(trenerZaupdate);
        return sacuvan;
    }

    @Override
    public void delete(Long id)
    {
        Trener trenerToUpdate = this.trenerRepository.getOne(id);
        trenerToUpdate.setObrisan(true);
        this.trenerRepository.save(trenerToUpdate);

    }

    @Override
    public Trener create(Trener trener) throws Exception
    {
        if (trener.getId() != null)
        {
            throw new Exception("ID mora biti null");
        }
        Trener noviTrener = this.trenerRepository.save(trener);
        return noviTrener;
    }

    @Override
    public List<Trener> findTrenerNeAktivan()
    {
        List<Trener> trener =this.trenerRepository.findFalse();
        return trener;
    }

    @Override
    public Trener pronadji(Long id)
    {
        Trener trener = this.trenerRepository.nadjiTreneraFitnesCentar(id);
        return trener;
    }
    @Override
    public Trener findByKimeandLozinka(String korisnicko_ime, String lozinka)
    {
        Trener trener = this.trenerRepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
        return trener;
    }

}
