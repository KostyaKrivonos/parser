package com.example.ParserMC3.dao;

import com.example.ParserMC3.entity.Enum.WordType;
import com.example.ParserMC3.entity.Word;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.SQLInsert;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;


@Component
public class WordDAO implements DAOwordInterface<Word, Integer> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Word entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Word entity) {
        em.remove(entity);
    }

    @Override
    public Word getById(Integer key) {
        return em.find(Word.class, key);
    }

    @Override
    public void updateStatus(Word entity) {
        em.merge(entity);
    }

    @Transactional
    @BatchSize(size = 200)
    public void saveAll(List<Word> wList){
        int batchSize = 200;

        for ( int i = 0; i < wList.size(); i++ ) {
            Word w = wList.get(i);
            if ( i > 0 && i % batchSize == 0 ) {
                //flush a batch of inserts and release memory
                em.flush();
                em.clear();
            }
            //em.persist( w );
           /* em.createNativeQuery("INSERT INTO dev.words (word, type, date) VALUES (:w, :t, :d) ")
                    .setParameter("w", w.getWord())
                    .setParameter("t", WordType.NOT_SKILL.ordinal())
                    .setParameter("d", new Date())
                    .executeUpdate();*/
            em.createNativeQuery("INSERT INTO dev.words (word, type, date) VALUES (:w, :t, :d) " +
                    "ON DUPLICATE KEY UPDATE word = word")
                    .setParameter("w", w.getWord())
                    .setParameter("t", WordType.NOT_SKILL.ordinal())
                    .setParameter("d", new Date())
                    .executeUpdate();
        }
    }
    @Transactional
    @BatchSize(size = 100)
    public List<Word> getWords(List<String> wList){
        List<Word> wordList = em.createQuery("FROM Word w WHERE w.word IN (:list)")
                .setParameter("list", wList).getResultList();
        return wordList;
    }
}
