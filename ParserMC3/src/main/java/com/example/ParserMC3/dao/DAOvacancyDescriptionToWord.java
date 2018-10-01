package com.example.ParserMC3.dao;

public interface DAOvacancyDescriptionToWord<E, K> {
    void add(E entity);
    void delete(E entity);
    E getById(K key);
    E getByIdWord(K key);
    E getByIdDescription(K key);
    void updateStatus(E entity);
}
