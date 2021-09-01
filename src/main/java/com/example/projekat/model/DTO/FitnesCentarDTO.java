package com.example.projekat.model.DTO;

public class FitnesCentarDTO {

    private Long id;

    private String naziv;

    private String adresa;

    private String broj_telefona;

    private String email;
    public FitnesCentarDTO(){
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }
    public void setBroj_tel_centrale(String broj_tel_centrale) {
        this.broj_telefona = broj_tel_centrale;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public FitnesCentarDTO(Long id, String naziv, String adresa, String broj_tel_centrale, String email) {

        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.broj_telefona = broj_tel_centrale;
        this.email = email;
    }

}
