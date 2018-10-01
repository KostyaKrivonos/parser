package com.example.ParserMC3;

import com.example.ParserMC3.Threads.MyThread;
import com.example.ParserMC3.dto.RequestDTO;
import com.example.ParserMC3.dto.ResponseDTO;
import com.example.ParserMC3.services.ExplorerService;
import com.example.ParserMC3.services.SeparationDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ParserController {
    @Autowired
    private SeparationDescription separationDescription;
    @Autowired
    private ExplorerService explorerService;


    @RequestMapping(value = "/separation", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public ResponseDTO sparta(@RequestBody RequestDTO idExplorer) {
        //System.out.println(sparta.getLink());
        ResponseDTO res = explorerService.getById(idExplorer);
        separationDescription.separation(res.getId());

        MyThread myThread = new MyThread();
        myThread.start();

        return res;
    }
}