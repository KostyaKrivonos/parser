package com.example.ParserMC4.model.LightEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacancy_desc_to_words")
//@BatchSize(size = 100)
public class VacDescToWord {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vacancy_descr_id")
    private int descriptionId;

    @Column(name = "word_Id")
    private int wordId;

    @Column (name = "quantity")
    private int quantity;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public VacDescToWord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescription() {
        return descriptionId;
    }

    public void setDescription(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWord(int wordId) {
        this.wordId = wordId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
