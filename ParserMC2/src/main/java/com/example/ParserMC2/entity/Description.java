package com.example.ParserMC2.entity;

import com.example.ParserMC2.entity.LightEntity.VacancyLight;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacancy_description")
public class Description {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyLight vacancy;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Description() {
        this.date = new Date();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VacancyLight getVacancy() {
        return vacancy;
    }

    public void setVacancy(VacancyLight vacancy) {
        this.vacancy = vacancy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
