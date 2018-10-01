package com.example.ParserMC4.controller;

import com.example.ParserMC4.dto.RequestDto;
import com.example.ParserMC4.model.LightEntity.Description;
import com.example.ParserMC4.model.LightEntity.Explorer;
import com.example.ParserMC4.model.LightEntity.Vacancy;
import com.example.ParserMC4.model.LightEntity.Word;
import com.example.ParserMC4.services.DescriptionService;
import com.example.ParserMC4.services.ExplorerService;
import com.example.ParserMC4.services.VacancyService;
import com.example.ParserMC4.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class UiController {

    @Autowired
    private ExplorerService explorerService;
    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private WordService wordService;


    @RequestMapping(value = "/vacancyList", method = RequestMethod.GET)
    public String vacancy(@RequestParam(name = "idExplorer") int id, Model model) {
        List<Vacancy> vacancyList = vacancyService.getAllVacancy(id);
        model.addAttribute("vacancyList", vacancyList);
        return "vacancyList";
    }

    @RequestMapping(value = "/explorerList", method = RequestMethod.GET)
    public String explorer(Model model) {
        List<Explorer> explorerList = explorerService.getAllExplorers();
        model.addAttribute("explorerList", explorerList);
        return "explorerList";
        /*public ModelAndView showAllExplorer() {
            ModelAndView modelAndView = new ModelAndView("explorerList");
            List<Explorer> explorerList = explorerService.getAllExplorers();
            modelAndView.addObject("explorerList", explorerList);
            return modelAndView;*/
    }

    @RequestMapping(value = "/descriptionVacancy", method = RequestMethod.GET)
    public String description(@RequestParam(name = "idVacancy") int id, Model model) {
        Description description = descriptionService.getDescriptionByIdVacancy(id);
        model.addAttribute("description", description);
        return "descriptionVacancy";
    }

    @RequestMapping(value = "/wordsList", method = RequestMethod.GET)
    public String words(Model model) {
        List<Word> wordsList = wordService.getAllWords();
        model.addAttribute("wordsList", wordsList);
        return "wordsList";
    }

    @RequestMapping(value = "/wordsOnlySkill", method = RequestMethod.GET)
    public String wordsOnlySkill(Model model) {
        List<Word> wordsOnlySkill = wordService.getWordsOnlySkill();
        model.addAttribute("wordsOnlySkill", wordsOnlySkill);
        return "wordsOnlySkill";
    }

    @RequestMapping(value = "/words", method = RequestMethod.POST)
    public String words(Model model, @ModelAttribute RequestDto word) {
        List<Integer> idWordCheckSkill = Arrays.asList(word.getId());
        List<Integer> idWordsByValues = wordService.getWordsByValues(idWordCheckSkill);
        if (idWordsByValues.size() != 0) {
            wordService.setWordTypeToNotSkill(idWordsByValues);
        }
        if (idWordCheckSkill.size() != 0) {
            wordService.setWordTypeToSkill(idWordCheckSkill);
        }
        String message = "DATA UPDATED SUCCESSFULLY";
        List<Word> wordsList = wordService.getAllWords();
        model.addAttribute("wordsList", wordsList);
        model.addAttribute("message", message);
        return "wordsList";
    }
}
