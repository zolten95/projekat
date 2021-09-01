package com.example.projekat.service.impl;


import com.example.projekat.model.Clan;
import com.example.projekat.repository.ClanRepository;
import com.example.projekat.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanServiceimpl implements ClanService {

    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceimpl(ClanRepository clanRepository) {
        super();
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan findOne(String kIme) {
        Clan clan = this.clanRepository.nadjiKime(kIme);
        return clan;
    }

    @Override
    public List<Clan> findAll() {
        List<Clan> clanovi = this.clanRepository.findAll();
        return clanovi;
    }

    @Override
    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID mora biti null");
        }
        Clan noviClan = this.clanRepository.save(clan);
        return noviClan;

    }

    @Override
    public Clan update(Clan clan) throws Exception {
        Clan ClanZaUpdate = this.clanRepository.getOne(clan.getId());
        if (ClanZaUpdate == null) {
            throw new Exception("Clan ne postoji");
        }
        ClanZaUpdate.setAktivan(clan.getAktivan());

        Clan sacuvan = this.clanRepository.save(ClanZaUpdate);
        return sacuvan;

    }

    @Override
    public void delete(Long id) {
        this.clanRepository.deleteById(id);
    }

    @Override
    public Clan findByKimeandLozinka(String korisnicko_ime, String lozinka) {
        Clan clan = this.clanRepository.findByKorisnicko_imeAndLozinka(korisnicko_ime, lozinka);
        return clan;
    }


}


