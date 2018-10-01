package com.example.ParserMC4.model.LightEntity;

import com.example.ParserMC4.model.LightEntity.Enum.VacancyStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vacancy")
public class Vacancy implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "explorerId")
    private int explorerId;

    @Column(name="vacancy_url")
    private String vacancyUrl;

    @Column(name="vacancy_status")
    private VacancyStatus vacancyStatus;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "location")
    private String location;

    @Column(name = "vacancy_title")
    private String vacancyTitle;

    public Vacancy() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public VacancyStatus getVacancyStatus() {
        return vacancyStatus;
    }

    public void setVacancyStatus(VacancyStatus vacancyStatus) {
        this.vacancyStatus = vacancyStatus;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", vacancyUrl: " + vacancyUrl +
                ", vacancyStatus: " + vacancyStatus;
    }
}
