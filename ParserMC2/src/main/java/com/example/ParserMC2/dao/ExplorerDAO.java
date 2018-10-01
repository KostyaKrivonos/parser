package com.example.ParserMC2.dao;

import com.example.ParserMC2.entity.FullEntity.Explorer;
import com.example.ParserMC2.entity.LightEntity.ExplorerLight;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ExplorerDAO implements DAOexplorerInterface<ExplorerLight, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(ExplorerLight entity) {
        em.persist(entity);
    }

    @Override
    public void delete(ExplorerLight entity) {
        em.remove(entity);
    }

    @Override
    public ExplorerLight getById(Integer id){
       return em.find(ExplorerLight.class,id); }

    @Override
    public void updateStatus(ExplorerLight entity) {
        em.merge(entity);
    }

}
