package com.example.ParserMC3.services;

import com.example.ParserMC3.dao.ExplorerDAO;
import com.example.ParserMC3.dto.RequestDTO;
import com.example.ParserMC3.dto.ResponseDTO;
import com.example.ParserMC3.entity.LightEntity.ExplorerLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ExplorerService {

    @Autowired
    private ExplorerDAO explorerDAO;

    @Transactional
    public ResponseDTO getById(RequestDTO idExplorer){
        ExplorerLight ex = new ExplorerLight();
        ex.setId(idExplorer.getIdExplorer());
        ResponseDTO resp = new ResponseDTO();
        resp.setId(ex.getId());
        // конвертувати ентіті в респонс дто і повернути
        return resp; }
}
