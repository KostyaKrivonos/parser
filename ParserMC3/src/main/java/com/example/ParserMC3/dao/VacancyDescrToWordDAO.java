package com.example.ParserMC3.dao;

import com.example.ParserMC3.entity.VacDescToWord;
import org.hibernate.annotations.BatchSize;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class VacancyDescrToWordDAO implements DAOvacancyDescriptionToWord<VacDescToWord, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(VacDescToWord entity) {
        em.persist(entity);
    }

    @Transactional
    @BatchSize(size = 200)
    public void saveAll(List<VacDescToWord> wList) {
        int batchSize = 200;

        for (int i = 0; i < wList.size(); i++) {
            VacDescToWord vdtw = wList.get(i);
            if (i > 0 && i % batchSize == 0) {
                //flush a batch of inserts and release memory
                em.flush();
                em.clear();
            }
            em.persist(vdtw);
        }
    }

    @Override
    public void delete(VacDescToWord entity) {
        em.remove(entity);
    }

    @Override
    public VacDescToWord getById(Integer key) {
        return em.find(VacDescToWord.class, key);
    }

    @Override
    public VacDescToWord getByIdWord(Integer key) {
        return null; /*em.createQuery("SELECT v FROM VacDescToWord v WHERE v.word =:WordId ")
                .setParameter("wordId", key);*/
    }

    @Override
    public VacDescToWord getByIdDescription(Integer key) {
        return null;
    }

    @Override
    public void updateStatus(VacDescToWord entity) {
        em.merge(entity);
    }
}
