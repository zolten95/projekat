package com.example.projekat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Administrator implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String datum_rodjenja;

    @Column
    private String korisnicko_ime;

    @Column
    private String lozinka;

    @Column
    private String kontakt;

    @Column
    private String email;

    @Column
    private String uloga;

    @Column
    private Boolean aktivan;


    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getKontakt() {
        return kontakt;
    }

    public String getEmail() {
        return email;
    }

    public String getUloga() {
        return uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Administrator(){}
}

