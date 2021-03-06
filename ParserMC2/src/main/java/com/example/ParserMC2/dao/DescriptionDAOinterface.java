package com.example.ParserMC2.dao;

public interface DescriptionDAOinterface <E, K>{
    void add(E entity);
    void delete(E entity);
    E getById(K key);
    E getByIdVacancy(K key);
    void updateStatus(E entity);

}
