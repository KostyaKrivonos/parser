package com.example.ParserMC4.services;

import com.example.ParserMC4.dao.WordDao;
import com.example.ParserMC4.model.LightEntity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class WordService {
    @Autowired
    private WordDao wordDao;

    @Transactional
    public void setWordTypeToSkill (List <Integer> idWordList){
        wordDao.setWordType(idWordList, 1);
    }

    @Transactional
    public void setWordTypeToNotSkill (List <Integer> idWordList){ wordDao.setWordType(idWordList, 0);}

    @Transactional
    public List<Word> getAllWords (){
        return wordDao.getAllWords();
    }

    @Transactional
    public List<Integer> getWordsByValues (List<Integer> idWordList){
        return  wordDao.getWordsByValues(idWordList);
    }

    @Transactional
    public List<Word> getWordsOnlySkill (){return wordDao.getWordsOnlySkill();}
}
