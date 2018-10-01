package com.example.ParserMC1.dao;

import com.example.ParserMC1.entity.Explorer;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ExplorerDAO implements DAOexplorerInterface <Explorer, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Explorer entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Explorer entity) {
        em.remove(entity);
    }

    @Override
    public Explorer getById(Integer id){
       return em.find(Explorer.class,id); }

    @Override
    public void updateStatus(Explorer entity) {
        em.merge(entity);
    }

}
