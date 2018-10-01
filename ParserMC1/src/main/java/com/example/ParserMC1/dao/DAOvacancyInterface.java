package com.example.ParserMC1.dao;


import java.util.List;

public interface DAOvacancyInterface<E, K>{
    void add(E entity);
    void delete(E entity);
    E getById(K key);
    List<E> findAllByIdExplorer(K key);
    void updateStatus (E entity);
}
