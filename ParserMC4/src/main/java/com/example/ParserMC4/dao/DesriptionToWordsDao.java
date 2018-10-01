package com.example.ParserMC4.dao;

import com.example.ParserMC4.model.LightEntity.VacDescToWord;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DesriptionToWordsDao implements  DAO<VacDescToWord, Integer>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public VacDescToWord getById(Integer key) {
        return em.find(VacDescToWord.class, key);
    }
}
