package com.example.projekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class FitnesCentar implements Serializable {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String email;

    @Column
    private String br_telefona;

    @OneToMany(mappedBy = "fitnes_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> sale;

    @OneToMany(mappedBy = "fitnes_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneri;

    @OneToMany(mappedBy = "fitnes_centar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termini;

    @OneToMany(mappedBy = "fitnes_centar",fetch =  FetchType.LAZY,cascade =CascadeType.ALL)
    private Set<Clan> clanovi;

    public FitnesCentar(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBr_telefona(String br_telefona) {
        this.br_telefona = br_telefona;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public String getEmail() {
        return email;
    }

    public String getBr_telefona() {
        return br_telefona;
    }

    public FitnesCentar(Long id,String naziv, String adresa, String email, String br_telefona) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.email = email;
        this.br_telefona = br_telefona;
    }
}
