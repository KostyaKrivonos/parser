package com.example.ParserMC3.entity;

import com.example.ParserMC3.entity.FullEntity.Description;
import com.example.ParserMC3.entity.LightEntity.DescriptionLight;
import com.example.ParserMC3.entity.LightEntity.VacancyLight;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacancy_desc_to_words")
@BatchSize(size = 100)
public class VacDescToWord {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "vacancy_descr_id")
    @Fetch(FetchMode.SELECT)
    private DescriptionLight description;

    @ManyToOne
    @JoinColumn(name = "word_id")
    @Fetch(FetchMode.SELECT)
    private Word word;

    @Column (name = "quantity")
    private int quantity;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public VacDescToWord() {
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DescriptionLight getDescription() {
        return description;
    }

    public void setDescription(DescriptionLight description) {
        this.description = description;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
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
