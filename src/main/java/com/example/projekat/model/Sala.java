package com.example.projekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Sala{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private int kapacitet;

    @Column(nullable = false)
    private int oznaka;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnes_centar;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termin;

    public Sala(){}

    public Sala(Long id, int kapacitet, int oznaka) {
        super();
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public Long getId() {
        return id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public int getOznaka() {
        return oznaka;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FitnesCentar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(FitnesCentar fitnes_centar) {
        this.fitnes_centar = fitnes_centar;
    }

    public Set<Termin> getTermin() {
        return termin;
    }

    public void setTermin(Set<Termin> termin) {
        this.termin = termin;
    }
}

