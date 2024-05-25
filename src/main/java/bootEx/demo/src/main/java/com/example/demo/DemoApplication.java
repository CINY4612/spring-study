package com.example.demo;

import com.example.demo.section03.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    Greet greet;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args)
                .getBean(DemoApplication.class).execute();
    }

    private void execute() {
        greet.greeting();
    }
}
