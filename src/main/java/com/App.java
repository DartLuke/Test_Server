package com;

import com.request.Client;
import com.request.ServerTemp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;


@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration

public class App {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "5648"));
        app.run(args);



//        Client n=new Client();
//        n.func();

    }
}
