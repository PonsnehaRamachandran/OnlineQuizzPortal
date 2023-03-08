package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Result;

@Repository

public interface ResultRepository extends JpaRepository<Result, Integer> {

	@Query(value = "select * from result where user_id =(select id from user_table where user_name = ?1)", nativeQuery = true)
	public List<Result> findByUserName(String userName);


}
