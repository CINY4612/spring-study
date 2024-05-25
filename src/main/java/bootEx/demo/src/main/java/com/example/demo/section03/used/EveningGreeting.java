package com.example.demo.section03.used;

import org.springframework.stereotype.Component;

@Component
public class EveningGreeting implements Greet {

    @Override
    public void greeting() {
        System.out.println("좋은 저녁입니다");
    }
}
