package com.example.ParserMC1.dao;

import com.example.ParserMC1.entity.Vacancy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Component
public class VacancyDAO implements DAOvacancyInterface<Vacancy, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Vacancy vac) {
        em.persist(vac);
    }

    @Transactional
    public void saveAll(ArrayList<Vacancy> vacList){
        int batchSize = 25;

        for ( int i = 0; i < vacList.size(); i++ ) {
            Vacancy v = vacList.get(i);
            if ( i > 0 && i % batchSize == 0 ) {
                //flush a batch of inserts and release memory
                em.flush();
                em.clear();
            }
            Vacancy vacancy = new Vacancy();
            vacancy.setCompanyName(v.getCompanyName());
            vacancy.setVacancyStatus(v.getVacancyStatus());
            vacancy.setVacancyTitle(v.getVacancyTitle());
            vacancy.setLocation(v.getLocation());
            vacancy.setExplorer(v.getExplorer());
            vacancy.setVacancyUrl(v.getVacancyUrl());
            vacancy.setDate(v.getDate());
            em.persist( vacancy );
        }
    }

    @Override
    public void delete(Vacancy vac){
        em.remove(vac);
    }

    @Override
    public Vacancy getById(Integer id) {
            return em.find(Vacancy.class, id);
    }

    @Override
    public ArrayList<Vacancy> findAllByIdExplorer(Integer idExplorer) {
        return (ArrayList<Vacancy>) em.createQuery("SELECT v FROM Vacancy v WHERE explorer = ?").setParameter(0, idExplorer).getResultList();
    }

    @Override
    public void updateStatus(Vacancy entity) {
        em.merge(entity);
    }
}

