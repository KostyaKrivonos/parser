package com.example.ParserMC2.entity.LightEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vacancy")
public class VacancyLight implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "explorerId")
    private int explorerId;

    @Column(name="vacancy_url")
    private String vacancyUrl;

    @Column(name="vacancy_status")
    private int vacancyStatus;

    public VacancyLight() {
    }

    public int getExplorerId() {
        return explorerId;
    }

    public void setExplorerId(int explorerId) {
        this.explorerId = explorerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVacancyUrl() {
        return vacancyUrl;
    }

    public void setVacancyUrl(String vacancyUrl) {
        this.vacancyUrl = vacancyUrl;
    }

    public int getVacancyStatus() {
        return vacancyStatus;
    }

    public void setVacancyStatus(int vacancyStatus) {
        this.vacancyStatus = vacancyStatus;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", vacancyUrl: " + vacancyUrl +
                ", vacancyStatus: " + vacancyStatus;
    }
}
