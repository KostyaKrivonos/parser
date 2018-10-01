package com.example.ParserMC1;

import com.example.ParserMC1.entity.Explorer;
import com.example.ParserMC1.services.ExplorerService;
import com.example.ParserMC1.services.ParserSevice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath*:spring.xml"})
public class ParserMc1Application {
    ExplorerService explorerService;
	public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ParserMc1Application.class, args);
        /*ParserSevice parserSevice = ctx.getBean(ParserSevice.class);
        //ExplorerService explorerService = ctx.getBean(ExplorerService.class);
        parserSevice.parser();
        ctx.close();*/
    }
}
