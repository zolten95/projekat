package com.example.projekat.repository;

import com.example.projekat.model.Clan;
import com.example.projekat.model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener,Long> {

    @Query("SELECT t FROM Trener t WHERE t.aktivan = false")
    List<Trener> findFalse();

    @Query("Select t from Trener t join fetch t.fitnes_centar  where t.id =?1")
    Trener nadjiTreneraFitnesCentar(Long id);

    @Query("Select t from Trener t where t.korisnicko_ime=?1 and t.lozinka=?2")
    Trener findByKorisnicko_imeAndLozinka(String korisnicko_ime, String lozinka);

}
