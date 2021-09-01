package com.example.projekat.repository;

import com.example.projekat.model.Sala;
import com.example.projekat.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query("Select s from Sala s where s.oznaka=?1")
    Sala nadjiSalaOznaka(int oznaka);
}
