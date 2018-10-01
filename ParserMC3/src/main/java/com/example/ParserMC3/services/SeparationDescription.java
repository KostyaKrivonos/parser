package com.example.ParserMC3.services;

import com.example.ParserMC3.dao.DescriptionDAO;
import com.example.ParserMC3.dao.VacancyDAO;
import com.example.ParserMC3.dao.VacancyDescrToWordDAO;
import com.example.ParserMC3.dao.WordDAO;
import com.example.ParserMC3.entity.Enum.DescriptionStatus;
import com.example.ParserMC3.entity.Enum.WordType;
import com.example.ParserMC3.entity.LightEntity.DescriptionLight;
import com.example.ParserMC3.entity.LightEntity.VacancyLight;
import com.example.ParserMC3.entity.VacDescToWord;
import com.example.ParserMC3.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Component
public class SeparationDescription {
    @Autowired
    private ExplorerService explorerService;
    @Autowired
    private DescriptionDAO descriptionDAO;
    @Autowired
    private WordDAO wordDAO;
    @Autowired
    private VacancyDescrToWordDAO vacancyDescrToWordDAO;
    @Autowired
    private VacancyDAO vacancyDAO;


    @Transactional
    public void separation(int id) {
        ArrayList<VacancyLight> vacList = vacancyDAO.findAllVacancysByIdExplorer(id);
        for (VacancyLight vac : vacList) {
            HashMap<String, Integer> uniqWordsMap = new HashMap<String, Integer>();
            Integer quentity = 0;
            List<Word> wordsList = new ArrayList<Word>();
            List<VacDescToWord> descToWordsList = new ArrayList<>();

            DescriptionLight desc = desc = descriptionDAO.getByIdVacancy(vac.getId());
            desc.setStatus(DescriptionStatus.IN_PROGRESS.ordinal());
            descriptionDAO.updateStatus(desc);

            String description = desc.getDescription();
            description = description.replaceAll(",|:|;|\\[|\\]|\\.|\\(|\\)|_|!|\\?|\\||•|—|\"|«|»|%|\\$", "");

            List<String> wList = Arrays.asList(description.split(" |/"));
            for (String wrd : wList) {
                //wrd = wrd.replaceAll(" ","");
                if (wrd.length() != 1 && wrd.length() > 1) {
                    quentity = uniqWordsMap.get(wrd);
                    if (quentity == null) {
                        uniqWordsMap.put(wrd.trim().toLowerCase(), 1);
                    }
                    else {
                        uniqWordsMap.put(wrd.trim().toLowerCase(), quentity + 1);
                    }
                }
            }
            desc.setStatus(DescriptionStatus.FINISHED.ordinal());
            descriptionDAO.updateStatus(desc);
            Set<String> onlyWords = uniqWordsMap.keySet();
            for (String w : onlyWords) {
                Word word = new Word();
                word.setWord(w);
                word.setType(WordType.NOT_SKILL.ordinal());
                wordsList.add(word);
            }
            wordDAO.saveAll(wordsList);

            List<String> onlyWordsList = new ArrayList(onlyWords);
            List<Word> wordsListFromDB = wordDAO.getWords(onlyWordsList);;
            for(Word w: wordsListFromDB){
                VacDescToWord vdtw = new VacDescToWord();
                vdtw.setDescription(desc);
                vdtw.setWord(w);
                Integer quent = uniqWordsMap.get(w.getWord());
                vdtw.setQuantity(quent);
                descToWordsList.add(vdtw);
                //System.out.println(" ");
            }
            vacancyDescrToWordDAO.saveAll(descToWordsList);
        }
    }
}
