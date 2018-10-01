package com.example.ParserMC4.dao;

import com.example.ParserMC4.model.LightEntity.Description;
import com.example.ParserMC4.model.LightEntity.Vacancy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Component
public class DescriptionDao implements DAO<Description, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Description getById(Integer key) {
        return em.find(Description.class, key);
    }

    @Transactional
    public Description getDescriptionByIdVacancy(Integer idVacancy) {
        return   (Description) em.createQuery("SELECT d FROM Description d WHERE d.vacancyId =:vacancyId")
                .setParameter("vacancyId", idVacancy).getSingleResult();
    }
}
