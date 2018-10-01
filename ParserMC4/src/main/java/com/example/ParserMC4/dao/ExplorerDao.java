package com.example.ParserMC4.dao;

import com.example.ParserMC4.model.LightEntity.Explorer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
@Component
public class ExplorerDao implements DAO<Explorer, Integer>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Explorer getById(Integer key) {
        return em.find(Explorer.class, key);
    }

    @Transactional
    public List<Explorer> getAllExplorers (){

        return em.createQuery("SELECT e FROM Explorer e" ).getResultList();
    }
}
