package com.example.ParserMC3.entity.FullEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "explorer")
public class Explorer implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="query")
    private String query;

    @Column(name="status")
    private int status;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="title")
    private String title = "we make a request for the vacancies in Java, on the website work.ua";

    public Explorer(int status) {
        this.query = null;
        this.status = status;
        this.date = new Date();
        this.title = title;
    }

    public Explorer() {
        this.date = new Date();
    }


    public int getId() {
        return id;
    }

    public String getQuery() {
        return query;
    }

    public int getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return " id:" + id  +
                ", query:'" + query + '\'' +
                ", status:" + status +
                ", date:" + date +
                ", title:'" + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explorer explorer = (Explorer) o;
        return status == explorer.status &&
                Objects.equals(query, explorer.query) &&
                Objects.equals(date, explorer.date) &&
                Objects.equals(title, explorer.title);
    }

    @Override
    public int hashCode() {
        int value = 17;
        value = 17*value + id;
        value = 17*value + date.hashCode();
        value = 17*value + query.hashCode();
        value = 17*value + title.hashCode();
        return value;
    }
}
