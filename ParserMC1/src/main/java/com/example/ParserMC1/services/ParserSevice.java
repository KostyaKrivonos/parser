package com.example.ParserMC1.services;

import com.example.ParserMC1.dao.ExplorerDAO;
import com.example.ParserMC1.dao.VacancyDAO;
import com.example.ParserMC1.entity.Explorer;
import com.example.ParserMC1.entity.Vacancy;
import com.example.ParserMC1.entity.enums.ExplorerStatus;
import com.example.ParserMC1.entity.enums.VacancyStatus;
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
public class ParserSevice {
    @Autowired
    private ExplorerDAO explorerService;
    @Autowired
    private VacancyDAO vacancyDAO;
    @Transactional
    public void parser(int id) {

        /*Explorer explorer = new Explorer();
        explorer.setQuery("https://www.work.ua/jobs-java/");
        explorer.setStatus(ExplorerStatus.NOT_STARTED.ordinal());*/
        Explorer explorer = explorerService.getById(id);
        explorer.setStatus(ExplorerStatus.NOT_STARTED.ordinal());
        ArrayList<Vacancy> vacancyList = new ArrayList<>();
        Document document = null;

        try {
            document = Jsoup.connect(explorer.getQuery()).get();

            explorer.setStatus(ExplorerStatus.IN_PROGRESS.ordinal());
            explorerService.updateStatus(explorer);

            Elements elements = document.getElementsByAttributeValue("class", "pagination hidden-xs");
            String countS = null;
            for (Element element : elements) {
                countS = element.child(5).text();
            }

            int numOfPages = Integer.parseInt(countS);
            for (int i = 1; i <= numOfPages; i++) {

                document = Jsoup.connect(explorer.getQuery() + "?page= " + i).get();


                Elements h2Elements = document.getElementsByAttributeValueStarting("class", "card card-hover card-visited wordwrap job-link");
                for (Element cElement : h2Elements) {

                    Elements urlElement = cElement.getElementsByTag("a");
                    String url = urlElement.attr("href");
                    String title = urlElement.text();

                    Elements comEl = cElement.getElementsByTag("b");
                    String company = comEl.text();

                    Elements locEl = cElement.getElementsByTag("span");
                    String location = null;
                    for (Element el : locEl) {
                        if (el.text().length() > 2 && "·".equals(el.text().substring(el.text().length() - 1))) {
                             location = el.text().substring(0, el.text().length() - 2);
                        }
                    }
                    Vacancy vacancy = new Vacancy();
                    vacancy.setCompanyName(company);
                    vacancy.setVacancyUrl("https://www.work.ua" + url);
                    vacancy.setExplorer(explorer);
                    vacancy.setLocation(location);
                    vacancy.setVacancyTitle(title);
                    vacancy.setVacancyStatus(VacancyStatus.NOT_STARTED.ordinal());
                    vacancyList.add(vacancy);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        vacancyDAO.saveAll(vacancyList);
        explorer.setStatus(ExplorerStatus.FINISHED.ordinal());
        explorerService.updateStatus(explorer);

    }
}
