package com.example.gyakorlatbeadando;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "feedback")
public class Kapcsolat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kuldo;
    private Date date;
    private String uzenet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKuldo() {
        return kuldo;
    }

    public void setKuldo(String kuldo) {
        this.kuldo = kuldo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }
}
