package com.example.ParserMC1.services;

import com.example.ParserMC1.dao.ExplorerDAO;
import com.example.ParserMC1.dto.RequestDTO;
import com.example.ParserMC1.dto.ResponseDTO;
import com.example.ParserMC1.entity.Explorer;
import com.example.ParserMC1.entity.enums.ExplorerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExplorerService {

    @Autowired
    private ExplorerDAO explorerDAO;


    @Transactional
    public ResponseDTO create(RequestDTO e) {
        Explorer explorer = new Explorer();
        explorer.setStatus(ExplorerStatus.NOT_STARTED.ordinal());
        explorer.setQuery(e.getQuery());
        //todo заповнити все з дто в експлорер
        explorerDAO.create(explorer);
        ResponseDTO resp = new ResponseDTO();
        resp.setId(explorer.getId());
        // конвертувати ентіті в респонс дто і повернути
        return resp;
    }

    @Transactional
    public void delete(Explorer ex) {
        explorerDAO.delete(ex);
    }

    @Transactional
    public Explorer getById(Integer id){
        return explorerDAO.getById(id);
    }

    @Transactional
    public void updateStatus(Explorer entity) {
        explorerDAO.updateStatus(entity);
    }
}
