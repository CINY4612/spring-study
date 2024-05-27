package com.example.demo;

import com.example.demo.section03.used.Greet;
import com.example.demo.section04.entity.Member;
import com.example.demo.section04.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    Greet greet;
    @Autowired
    MemberCrudRepository repository;

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(DemoApplication.class, args);
        application.getBean(DemoApplication.class).greet();
        application.getBean(DemoApplication.class).crudExecute();
    }

    private void greet() {
        greet.greeting();
    }

    private void crudExecute() {
        executeInsert();
        executeSelect();
    }

    private void executeInsert() {
        Member member = new Member(null, "ciny");
        member = repository.save(member);
        System.out.println("등록 데이터 : " + member);
    }

    private void executeSelect() {
        Iterable<Member> members = repository.findAll();
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
