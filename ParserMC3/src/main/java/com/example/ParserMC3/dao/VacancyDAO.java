package com.example.ParserMC3.dao;

import com.example.ParserMC3.entity.LightEntity.VacancyLight;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Component
public class VacancyDAO implements DAOvacancyInterface<VacancyLight, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(VacancyLight vac) {
        em.persist(vac);
    }

    @Override
    public void delete(VacancyLight vac){
        em.remove(vac);
    }

    @Override
    public VacancyLight getById(Integer id) {
            return em.find(VacancyLight.class, id);
    }

    @Override
    public ArrayList<VacancyLight> findAllVacancysByIdExplorer(Integer idExplorer) {
        return  (ArrayList<VacancyLight>) em
                .createQuery("SELECT v FROM VacancyLight v WHERE v.explorerId =:explorerId    ")
                .setParameter("explorerId", idExplorer)
                .getResultList();
    }

    @Override
    public void updateStatus(VacancyLight entity) {
        em.merge(entity);
    }




    /*@Transactional
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
            vacancy.setExplorerId(v.getExplorerId());
            vacancy.setVacancyUrl(v.getVacancyUrl());
            vacancy.setDate(v.getDate());
            em.persist( vacancy );
        }
    }*/
}

