package com.example.ParserMC4.services;

import com.example.ParserMC4.dao.ExplorerDao;
import com.example.ParserMC4.model.LightEntity.Explorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ExplorerService {
    @Autowired
    private ExplorerDao explorerDao;
    @Transactional
    public List<Explorer> getAllExplorers(){
        return explorerDao.getAllExplorers();
    }
}
