package com.example.projekat.model.DTO;

public class SalaDTO {

    private Long id;
    private int kapacitet;
    private int oznaka;
    private FitnesCentarDTO fitnesCentar;
    public FitnesCentarDTO getFitnessCentar() {
        return fitnesCentar;
    }

    public void setFitnessCentar(FitnesCentarDTO fitnessCentar) {
        this.fitnesCentar = fitnessCentar;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getKapacitet() {
        return kapacitet;
    }
    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }
    public int getOznaka() {
        return oznaka;
    }
    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public SalaDTO(Long id, int kapacitet, int oznaka) {
        super();
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.id=id;
    }
    public SalaDTO ()
    {}
}
