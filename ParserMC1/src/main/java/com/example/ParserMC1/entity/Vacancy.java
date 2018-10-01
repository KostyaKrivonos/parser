package com.example.ParserMC1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "vacancy")
public class Vacancy implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "explorerId")
    private Explorer explorer;

    @Column(name="vacancy_url")
    private String vacancyUrl;

    @Column(name="vacancy_status")
    private int vacancyStatus;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="company_name")
    private String companyName;

    @Column(name="location")
    private String location;

    @Column(name="vacancy_title")
    private String vacancyTitle;

    public Vacancy() {
        this.date = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExplorer(Explorer explorer_id) {
        this.explorer = explorer_id;
    }

    public void setVacancyUrl(String vacancy_url) {
        this.vacancyUrl = vacancy_url;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCompanyName(String company_name) {
        this.companyName = company_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVacancyTitle(String vacancy_title) {
        this.vacancyTitle = vacancy_title;
    }

    public int getId() {
        return id;
    }

    public Explorer getExplorer() {
        return explorer;
    }

    public String getVacancyUrl() {
        return vacancyUrl;
    }

    public int getVacancyStatus() {
        return vacancyStatus;
    }

    public Date getDate() {
        return date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyStatus(int vacancy_status) {
        this.vacancyStatus = vacancy_status;
    }

    @Override
    public String toString() {
        return "id:"  +
                ", explorer_id:" + explorer +
                ", vacancy_url:" + vacancyUrl +
                ", vacancy_status:" + vacancyStatus +
                ", date:" + date +
                ", company_name:" + companyName +
                ", location:" + location +
                ", vacancy_title:" + vacancyTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(explorer, vacancy.explorer) &&
                Objects.equals(vacancyUrl, vacancy.vacancyUrl) &&
                vacancyStatus == vacancy.vacancyStatus &&
                Objects.equals(date, vacancy.date) &&
                Objects.equals(companyName, vacancy.companyName) &&
                Objects.equals(location, vacancy.location) &&
                Objects.equals(vacancyTitle, vacancy.vacancyTitle);
    }

    @Override
    public int hashCode() {
        int value = 31;
        value = 31*value + id;
        value = 31*value + date.hashCode();
        value = 31*value + companyName.hashCode();
        value = 31*value + explorer.hashCode();
        value = 31*value + location.hashCode();
        value = 31*value + vacancyTitle.hashCode();
        value = 31*value + vacancyUrl.hashCode();
        return value;
    }
}
