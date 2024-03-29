package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Result;

@Repository

public interface ResultRepository extends JpaRepository<Result, Integer> {

	@Query("SELECT r FROM Result r WHERE r.user.userName = :userName")
	public List<Result> findByUserName(String userName);	

}
