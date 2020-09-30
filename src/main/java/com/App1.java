package com;

import com.bash.Bash;
import com.singleton.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;


@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class App1 {


    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "5773"));
        app.run(args);


        Singleton.getInstance().setTestEnabled(true);


        Bash bash = new Bash();
        bash.executeScript(bash.STOP);
        bash.executeScript(bash.SETUP);
        bash.startInMultiThread();


    }
}
