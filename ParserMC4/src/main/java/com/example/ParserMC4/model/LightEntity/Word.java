package com.example.ParserMC4.model.LightEntity;

import com.example.ParserMC4.model.LightEntity.Enum.WordType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "words")
//@BatchSize(size = 100)
public class Word implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "word")
    private String word;

    @Column (name = "type")
    private int type;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Word() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
