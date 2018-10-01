package com.example.ParserMC1;


import com.example.ParserMC1.Threads.MyThread;
import com.example.ParserMC1.dto.RequestDTO;
import com.example.ParserMC1.dto.ResponseDTO;
import com.example.ParserMC1.restClient.RestClientMC2;
import com.example.ParserMC1.services.ExplorerService;
import com.example.ParserMC1.services.ParserSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ParserController {
    @Autowired
    private ParserSevice parserSevice;
    @Autowired
    private ExplorerService explorerService;
    @Autowired
    private RestClientMC2 restClientMC2;

    @RequestMapping(value = "/parser", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public ResponseDTO sparta(@RequestBody RequestDTO query) {
        //System.out.println(sparta.getLink());
        ResponseDTO res = explorerService.create(query);
        parserSevice.parser(res.getId());

        restClientMC2.postMC2(res.getId());

        MyThread myThread = new MyThread();
        myThread.start();

        return res;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserController.class);

    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity healthCheck() {

        LOGGER.info("#healthCheck ...");
        return ResponseEntity.ok().build();
    }
}