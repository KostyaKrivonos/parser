package com.example.ParserMC3.entity.LightEntity;

import javax.persistence.*;

@Entity
@Table(name = "vacancy_description")
public class DescriptionLight {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vacancy_id")
    private int vacancyId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    public DescriptionLight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
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
}
