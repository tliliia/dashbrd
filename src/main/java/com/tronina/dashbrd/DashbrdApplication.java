package com.tronina.dashbrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DashbrdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashbrdApplication.class, args);
    }

}
