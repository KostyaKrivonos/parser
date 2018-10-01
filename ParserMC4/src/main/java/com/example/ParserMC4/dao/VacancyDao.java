package com.example.ParserMC4.dao;

import com.example.ParserMC4.model.LightEntity.Vacancy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Component
public class VacancyDao implements  DAO<Vacancy, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vacancy getById(Integer key) {
        return em.find(Vacancy.class, key);
    }

    @Transactional
    public List<Vacancy> getAllVacancysByIdExplorer(Integer idExplorer) {
        return  (List<Vacancy>) em
                .createQuery("SELECT v FROM Vacancy v WHERE v.explorerId =:explorerId    ")
                .setParameter("explorerId", idExplorer)
                .getResultList();
    }
}
