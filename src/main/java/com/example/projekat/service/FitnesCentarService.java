package com.example.projekat.service;

import com.example.projekat.model.FitnesCentar;
import com.example.projekat.model.Trener;

import java.util.List;

public interface FitnesCentarService {



    List<FitnesCentar> findAll();

    FitnesCentar create(FitnesCentar fitnesCentar) throws Exception;

    FitnesCentar nadji (String id);

    void delete(Long id);

    FitnesCentar update(FitnesCentar fitnescentar) throws Exception;




}
