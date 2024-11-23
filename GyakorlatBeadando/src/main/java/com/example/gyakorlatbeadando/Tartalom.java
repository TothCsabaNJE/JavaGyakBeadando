package com.example.gyakorlatbeadando;

import jakarta.persistence.*;

@Entity
@Table(name="tartalom")
public class Tartalom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long sutiid;
    private String mentes;


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

    public String getMentes() {
        return mentes;
    }

    public void setMentes(String mentes) {
        this.mentes = mentes;
    }

    @Override
    public String toString() {
        return "Tartalom{" +
                "mentes='" + mentes + '\'' +
                ", sutiid=" + sutiid +
                ", id=" + id +
                '}';
    }

    public Tartalom(Long id, Long sutiid, String mentes) {
        this.id = id;
        this.sutiid = sutiid;
        this.mentes = mentes;
    }

    public Tartalom() {}
}
