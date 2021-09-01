package com.example.projekat.repository;

import com.example.projekat.model.FitnesCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FitnesCentarRepository extends JpaRepository<FitnesCentar, Long> {

    @Query("Select f from FitnesCentar f where f.naziv=?1")
    FitnesCentar nadji(String id);


}
