package com.example.demo.section10.quiz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    @Query("SELECT id FROM quiz " +
            "ORDER BY RANDOM() LIMIT 1")
    Integer getRandomId();
}
