package com.example.demo.section04.repository;

import com.example.demo.section04.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, Integer> {
}
