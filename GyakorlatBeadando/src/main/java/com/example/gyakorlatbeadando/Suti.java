package com.example.gyakorlatbeadando;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="suti")
public class Suti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nev;
    private String tipus;
    private boolean dijazott;

    @OneToMany(mappedBy = "suti")
    private Set<Ar> ar;

    @OneToMany(mappedBy = "suti")
    private Set<Tartalom> tartalom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Set<Ar> getAr() {
        return ar;
    }

    public void setAr(Set<Ar> ar) {
        this.ar = ar;
    }

    public Set<Tartalom> getTartalom() {
        return tartalom;
    }

    public void setTartalom(Set<Tartalom> tartalom) {
        this.tartalom = tartalom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean isDijazott() {
        return dijazott;
    }

    public void setDijazott(boolean dijazott) {
        this.dijazott = dijazott;
    }

    @Override
    public String toString() {
        return "Suti{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", tipus='" + tipus + '\'' +
                ", dijazott=" + dijazott +
                '}';
    }

    public Suti(Long id, String nev, String tipus, boolean dijazott) {
        this.id = id;
        this.nev = nev;
        this.tipus = tipus;
        this.dijazott = dijazott;
    }

    public Suti() {
    }
}
