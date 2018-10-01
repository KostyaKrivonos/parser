package com.example.ParserMC2.dao;

public interface DAOexplorerInterface <E, K>{
    void create(E entity);
    void delete(E entity);
    E getById(K key);
    void updateStatus(E entity);
}
