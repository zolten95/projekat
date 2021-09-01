package com.example.projekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Clan implements Serializable {

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


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Trening> odradjeni;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Trening> prijavljeni;

    @ManyToOne(fetch = FetchType.EAGER)
    public FitnesCentar fitnes_centar;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termin;

    public Clan() {

    }

    public Clan(String ime, String prezime, String datum_rodjenja, String korisnicko_ime, String lozinka, String kontakt, String email, String uloga) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.kontakt = kontakt;
        this.email = email;
        this.uloga = uloga;
    }
}
