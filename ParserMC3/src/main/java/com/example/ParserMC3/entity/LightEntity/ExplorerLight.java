package com.example.ParserMC3.entity.LightEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "explorer")
public class ExplorerLight implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public ExplorerLight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
