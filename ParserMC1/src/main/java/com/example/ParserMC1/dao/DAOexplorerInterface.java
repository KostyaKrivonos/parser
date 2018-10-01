package com.example.ParserMC1.dao;

public interface DAOexplorerInterface <E, K>{
    void create(E entity);
    void delete(E entity);
    E getById(K key);
    void updateStatus (E entity);
}
