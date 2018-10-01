package com.example.ParserMC3.dao;

import java.util.List;

public interface DAOwordInterface <E, K>{
    void add(E entity);
    void delete(E entity);
    E getById(K key);
    void updateStatus(E entity);
}
