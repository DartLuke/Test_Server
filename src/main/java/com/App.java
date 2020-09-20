package com;

import com.bash.Bash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;


@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration

public class App {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "5773"));
        app.run(args);



        Bash bash = new Bash();
        bash.executeScript(bash.STOP);
        bash.executeScript(bash.SETUP);
        bash.startInMultiThread();



      //  bash.executeMore();


    }
}
