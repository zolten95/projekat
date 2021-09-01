package com.example.projekat.repository;

import com.example.projekat.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {
    @Query("Select t from Termin t join fetch t.trening  where t.trening.id =?1 order by t.datum desc")
    List<Termin> nadjisortirane(Long id);

    @Query("Select t from Termin t join fetch t.fitnes_centar  where t.id =?1")
    Termin nadjiTerminFitnesCentar(Long id);

    @Query("Select t from Termin t join fetch t.trening join fetch t.sala where t.trening.id =?1")
    Termin nadjiTerminSaTreningom(Long id);
}
