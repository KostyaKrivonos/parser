package com.example.ParserMC2.dao;


import java.util.List;

public interface DAOvacancyInterface<E, K>{
    void add(E entity);
    void delete(E entity);
    E getById(K key);
    List<E> findAllVacancysByIdExplorer(K key);
    void updateStatus(K key, K status);
}
