package com.example.ParserMC2;

import com.example.ParserMC2.Threads.MyThread;
import com.example.ParserMC2.dto.RequestDTO;
import com.example.ParserMC2.dto.ResponseDTO;

import com.example.ParserMC2.restClient.RestClientMC3;
import com.example.ParserMC2.services.ExplorerService;
import com.example.ParserMC2.services.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ParserController{
    @Autowired
    private ParserService parserSevice;
    @Autowired
    private ExplorerService explorerService;
    @Autowired
    private RestClientMC3 restClientMC3;

    @RequestMapping(value = "/description", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public ResponseDTO sparta(@RequestBody RequestDTO idExplorer) {
        //System.out.println(sparta.getLink());
        ResponseDTO res = explorerService.getById(idExplorer);
        parserSevice.parser(res.getId());

        restClientMC3.postMC3(res.getId());

        MyThread myThread = new MyThread();
        myThread.start();

        return res;
    }
}