package com.example.ParserMC2.dao;

import com.example.ParserMC2.entity.Description;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class DescriptionDAO implements  DescriptionDAOinterface<Description, Integer>{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Description entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Description entity) {em.remove(entity); }

    @Override
    public Description getById(Integer id) {
        return em.find(Description.class, id);
    }

    @Override
    public Description getByIdVacancy(Integer key) {
        return null;
    }

    @Override
    public void updateStatus(Description entity) {
        em.merge(entity);
    }

    @Transactional
    public void saveAll(ArrayList<Description> descList){
        int batchSize = 25;

        for ( int i = 0; i < descList.size(); i++ ) {
            Description d = descList.get(i);
            if ( i > 0 && i % batchSize == 0 ) {
                //flush a batch of inserts and release memory
                em.flush();
                em.clear();
            }
            em.persist(d);
        }
    }
}
