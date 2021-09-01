package com.example.projekat.repository;

import com.example.projekat.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {

    List<Trening> findByOrderByCenaAsc ();

    List<Trening> findByNaziv(String naziv);

    List<Trening> findByOpis(String opis);

    List<Trening> findByCena(Double cena);

    @Query("Select t from Trening t where t.naziv=?1")
    Trening nadjiNazi(String naziv);




}
