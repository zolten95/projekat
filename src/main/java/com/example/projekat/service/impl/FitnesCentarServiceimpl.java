package com.example.projekat.service.impl;


import com.example.projekat.model.FitnesCentar;
import com.example.projekat.repository.FitnesCentarRepository;
import com.example.projekat.service.FitnesCentarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnesCentarServiceimpl implements FitnesCentarService {

    private final FitnesCentarRepository fitnesCentarRepository;

    public FitnesCentarServiceimpl(FitnesCentarRepository fitnesCentarRepository) {
        super();
        this.fitnesCentarRepository = fitnesCentarRepository;
    }

    @Override
    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnescentri = this.fitnesCentarRepository.findAll();

        return fitnescentri;
    }

    @Override
    public FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
        if(fitnesCentar.getId() != null)
        {
            throw new Exception("id mora biti null!");
        }
        FitnesCentar fitnesCentar1 = this.fitnesCentarRepository.save(fitnesCentar);
        return fitnesCentar1;
    }
    @Override
    public void delete(Long id) {
        this.fitnesCentarRepository.deleteById(id);

    }

    @Override
    public FitnesCentar nadji(String id) {
        return this.fitnesCentarRepository.nadji(id);

    }

    @Override
    public FitnesCentar update(FitnesCentar fitnescentar) throws Exception {


        FitnesCentar fitnescentarToUpdate = this.fitnesCentarRepository.getOne(fitnescentar.getId());
        if (fitnescentarToUpdate == null) {
            throw new Exception("Fitness centar doesn't exist!");
        }
        fitnescentarToUpdate.setNaziv(fitnescentar.getNaziv());
        fitnescentarToUpdate.setEmail(fitnescentar.getEmail());
        fitnescentarToUpdate.setAdresa(fitnescentar.getAdresa());
        fitnescentarToUpdate.setBr_telefona(fitnescentar.getBr_telefona());


        FitnesCentar sacuvan = this.fitnesCentarRepository.save(fitnescentarToUpdate);
        return sacuvan;
    }

}
