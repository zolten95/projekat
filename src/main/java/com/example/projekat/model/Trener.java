package com.example.projekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

public class Trener implements  Serializable {

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
    private boolean aktivan;

    @Column
    private boolean obrisan;


    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(Boolean obrisan) {
        this.obrisan = obrisan;
    }

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

    public Boolean isAktivan() {
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnesCentar fitnes_centar;

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Trening> treninzi;

    @JsonIgnore
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termin;

    public Trener() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public FitnesCentar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(FitnesCentar fitnes_centar) {
        this.fitnes_centar = fitnes_centar;
    }

    public Set<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(Set<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public void setTermin(Set<Termin> termin) {
        this.termin = termin;
    }

    public Trener(String ime, String prezime, String datum_rodjenja, String korisnicko_ime, String lozinka, String kontakt, String email, boolean obisan, boolean aktivan) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.kontakt = kontakt;
        this.email = email;
        this.obrisan = obisan;
        this.aktivan = aktivan;

    }

    public Set<Termin> getTermin() {
        return termin;
    }
}
