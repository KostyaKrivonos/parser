package com.example.ParserMC4.dao;

import com.example.ParserMC4.model.LightEntity.Word;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class WordDao implements DAO<Word, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Word getById(Integer key) {
        return em.find(Word.class, key);
    }

    @Transactional
    public void setWordType(List<Integer>idWordList, int type){
        em.createQuery("UPDATE Word w SET w.type = :type WHERE w.id IN (:list)")
                .setParameter("type", type)
                .setParameter("list", idWordList)
                .executeUpdate();
    }

    @Transactional
    public List<Word> getAllWords (){
        return em.createQuery("SELECT w FROM Word w" ).getResultList();
    }

    @Transactional
    public List<Integer> getWordsByValues (List<Integer> idWordList){
        int type = 1;
        return em.createQuery("SELECT w.id FROM Word w WHERE w.type = :type AND w.id NOT IN (:list)")
                .setParameter("list", idWordList)
                .setParameter("type", type)
                .getResultList();
    }
    @Transactional
    public List<Word> getWordsOnlySkill (){
        int type = 1;
        return em.createQuery("SELECT w FROM Word w WHERE w.type = :type")
                .setParameter("type", type)
                .getResultList();
    }
}
