package com.example.projekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String datum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }


    public void setDatum(String datum) {
        this.datum = datum;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnes_centar;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Clan> clans;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    public Termin(Long id, String datum)
    {
        super();
        this.id = id;
        this.datum = datum;
    }
    public Termin(){}

    public FitnesCentar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(FitnesCentar fitnes_centar) {
        this.fitnes_centar = fitnes_centar;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Set<Clan> getClans() {
        return clans;
    }

    public void setClans(Set<Clan> clans) {
        this.clans = clans;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
}
