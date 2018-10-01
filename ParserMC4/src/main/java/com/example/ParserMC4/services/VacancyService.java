package com.example.ParserMC4.services;

import com.example.ParserMC4.dao.VacancyDao;
import com.example.ParserMC4.model.LightEntity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class VacancyService {

    @Autowired
    private VacancyDao vacancyDao;

    @Transactional
    public List<Vacancy> getAllVacancy(int idExplorer){
        return vacancyDao.getAllVacancysByIdExplorer(idExplorer);
    }
}
