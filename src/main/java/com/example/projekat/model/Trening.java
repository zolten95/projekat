package com.example.projekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Trening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tip;

    @Column
    private int trajanje;

    @Column
    private double cena;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trener trener;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Clan> clan;


    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termini;



    public Trening(){}
    public Long getId() {
        return id;
    }

    public double getCena() {
        return cena;
    }



    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getTip() {
        return tip;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public Set<Clan> getClan() {
        return clan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
