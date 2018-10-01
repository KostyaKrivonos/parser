package com.example.ParserMC2.services;

import com.example.ParserMC2.dao.DescriptionDAO;
import com.example.ParserMC2.dao.ExplorerDAO;
import com.example.ParserMC2.dao.VacancyDAO;
import com.example.ParserMC2.entity.Description;
import com.example.ParserMC2.entity.Enum.DescriptionStatus;
import com.example.ParserMC2.entity.Enum.VacancyStatus;
import com.example.ParserMC2.entity.LightEntity.VacancyLight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class ParserService {

    @Autowired
    private ExplorerDAO explorerDAO;
    @Autowired
    private VacancyDAO vacancyDAO;
    @Autowired
    private DescriptionDAO descriptionDAO;

    @Transactional
    public void parser(int id){
        ArrayList<VacancyLight> vacList = vacancyDAO.findAllVacancysByIdExplorer(id);
        Document document = null;
        ArrayList<Description> descriptionsList = new ArrayList<>();
        VacancyLight vacLight = null;

            try {
                for(VacancyLight v:vacList) {
                    vacLight = v;
                    document = Jsoup.connect(vacLight.getVacancyUrl()).get();
                    vacLight.setVacancyStatus(VacancyStatus.IN_PROGRESS.ordinal());
                    vacancyDAO.updateStatus(vacLight.getId(), vacLight.getVacancyStatus());
                    Description d = new Description();
                    d.setVacancy(vacLight);
                    Elements elem = document.getElementsByAttributeValueStarting("class", "card wordwrap");
                    //ArrayList<Description> descriptionsList = new ArrayList<>();
                    for (Element d1Element : elem){
                        Elements des1Element = d1Element.getElementsByTag("p");
                        String des1 = des1Element.text();

                        Elements des2Element = d1Element.getElementsByTag("ul");
                        String des2 = des2Element.text();
                        d.setStatus(DescriptionStatus.NOT_STARTED.ordinal());
                        d.setDescription(des1 + " " + des2);
                        //System.out.println(des2);
                        descriptionsList.add(d);
                        vacLight.setVacancyStatus(VacancyStatus.FINISHED.ordinal());
                    }
                }
                descriptionDAO.saveAll(descriptionsList);
                vacancyDAO.updateStatus(vacLight.getId(), vacLight.getVacancyStatus());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
