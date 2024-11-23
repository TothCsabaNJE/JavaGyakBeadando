package com.example.gyakorlatbeadando;

import jakarta.persistence.*;

@Entity
@Table(name="ar")
public class Ar {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long sutiid;
    private int ertek;
    private String egyseg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sutiid", insertable = false, updatable = false)
    private Suti suti;

    public Suti getSuti() {
        return suti;
    }

    public void setSuti(Suti suti) {
        this.suti = suti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSutiid() {
        return sutiid;
    }

    public void setSutiid(Long sutiid) {
        this.sutiid = sutiid;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public String getEgyseg() {
        return egyseg;
    }

    public void setEgyseg(String egyseg) {
        this.egyseg = egyseg;
    }

    @Override
    public String toString() {
        return "Ar{" +
                "id=" + id +
                ", sutiid=" + sutiid +
                ", ertek=" + ertek +
                ", egyseg='" + egyseg + '\'' +
                '}';
    }

    public Ar(Long id, Long sutiid, int ertek, String egyseg) {
        this.id = id;
        this.sutiid = sutiid;
        this.ertek = ertek;
        this.egyseg = egyseg;
    }

    public Ar() {}
}
