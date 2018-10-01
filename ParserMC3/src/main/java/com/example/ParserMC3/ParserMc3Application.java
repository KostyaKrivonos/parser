package com.example.ParserMC3;

import com.example.ParserMC3.services.SeparationDescription;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath*:spring.xml"})
public class ParserMc3Application {
    //ExplorerService explorerService;

	public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ParserMc3Application.class, args);
        /*SeparationDescription parserService = ctx.getBean(SeparationDescription.class);
        //ExplorerService explorerService = ctx.getBean(ExplorerService.class);
        parserService.separation(1);
        ctx.close();*/
    }
}
