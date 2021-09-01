package com.example.projekat.repository;

import com.example.projekat.model.Administrator;
import com.example.projekat.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    @Query("Select a from Administrator a where a.korisnicko_ime=?1 and a.lozinka=?2")
    Administrator findByKorisnicko_imeAndLozinka(String korisnicko_ime, String lozinka);
}
