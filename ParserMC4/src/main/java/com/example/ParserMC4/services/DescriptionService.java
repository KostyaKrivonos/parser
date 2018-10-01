package com.example.ParserMC4.services;

import com.example.ParserMC4.dao.DescriptionDao;
import com.example.ParserMC4.model.LightEntity.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class DescriptionService {

    @Autowired
    private DescriptionDao descriptionDao;

    @Transactional
    public Description getDescriptionByIdVacancy(Integer idVacancy) {
        return  descriptionDao.getDescriptionByIdVacancy(idVacancy);
    }
}
