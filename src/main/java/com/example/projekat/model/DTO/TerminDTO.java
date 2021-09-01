package com.example.projekat.model.DTO;

public class TerminDTO {

    private Long id;
    private String datum;
    private FitnesCentarDTO fitnesscentar;
    private SalaDTO sala;
    private TreningDTO trening;




    public TreningDTO getTrening() {
        return trening;
    }


    public void setTrening(TreningDTO trening) {
        this.trening = trening;
    }


    public SalaDTO getSala() {
        return sala;
    }


    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }


    public void setFitnessCentar(FitnesCentarDTO fitnesscentar) {
        this.fitnesscentar = fitnesscentar;
    }


    public FitnesCentarDTO getFitnesscentar() {
        return fitnesscentar;
    }


    public TerminDTO(Long id, String datum) {
        super();
        this.id = id;
        this.datum = datum;
    }

    public String getDatum() {
        return datum;
    }
    public void setDatum(String date) {
        this.datum = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
