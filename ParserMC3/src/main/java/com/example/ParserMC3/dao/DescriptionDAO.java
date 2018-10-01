package com.example.ParserMC3.dao;

import com.example.ParserMC3.entity.FullEntity.Description;
import com.example.ParserMC3.entity.LightEntity.DescriptionLight;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class DescriptionDAO implements  DescriptionDAOinterface<DescriptionLight, Integer>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(DescriptionLight entity) {
        em.persist(entity);
    }

    @Override
    public void delete(DescriptionLight entity) {em.remove(entity); }

    @Override
    public DescriptionLight getById(Integer id) {
        return em.find(DescriptionLight.class, id);
    }

    @Override
    public DescriptionLight getByIdVacancy(Integer key) {
        DescriptionLight des =(DescriptionLight) em.createQuery("SELECT d FROM DescriptionLight d WHERE d.vacancyId =:id")
                .setParameter("id", key).getSingleResult();
        return des;
    }

    @Override
    public void updateStatus(DescriptionLight entity) {
        em.merge(entity);
    }

    @Transactional
    public void saveAll(ArrayList<DescriptionLight> descList){
        int batchSize = 25;

        for ( int i = 0; i < descList.size(); i++ ) {
            DescriptionLight d = descList.get(i);
            if ( i > 0 && i % batchSize == 0 ) {
                //flush a batch of inserts and release memory
                em.flush();
                em.clear();
            }
            em.persist(d);
        }
    }
}
