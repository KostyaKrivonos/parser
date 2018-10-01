package com.example.ParserMC4.model.LightEntity;

import com.example.ParserMC4.model.LightEntity.Enum.DescriptionStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacancy_description")
public class Description {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vacancy_id")
    private int vacancyId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private DescriptionStatus status;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;


    public Description() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public DescriptionStatus getStatus() {
        return status;
    }

    public void setStatus(DescriptionStatus status) {
        this.status = status;
    }
}
