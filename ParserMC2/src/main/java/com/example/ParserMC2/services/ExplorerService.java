package com.example.ParserMC2.services;

import com.example.ParserMC2.dao.ExplorerDAO;
import com.example.ParserMC2.dto.RequestDTO;
import com.example.ParserMC2.dto.ResponseDTO;
import com.example.ParserMC2.entity.FullEntity.Explorer;
import com.example.ParserMC2.entity.LightEntity.ExplorerLight;
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
