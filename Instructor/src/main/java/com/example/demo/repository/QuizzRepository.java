package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {

}
