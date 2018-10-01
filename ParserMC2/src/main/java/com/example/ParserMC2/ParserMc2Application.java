package com.example.ParserMC2;

import com.example.ParserMC2.services.ParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath*:spring.xml"})
public class ParserMc2Application {
    //ExplorerService explorerService;

	public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ParserMc2Application.class, args);
        /*ParserService parserService = ctx.getBean(ParserService.class);
        //ExplorerService explorerService = ctx.getBean(ExplorerService.class);
        parserService.parser(1);
        ctx.close();*/
    }
}
