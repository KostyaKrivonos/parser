package com.example.ParserMC4.dao;

public interface DAO <E, K>{
    E getById(K key);
}
