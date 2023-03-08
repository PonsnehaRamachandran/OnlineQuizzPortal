package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Result;
import com.example.demo.exceptions.ResultException;

@Service
public interface ResultService  {
	
	public List<Result> getAllResult() throws ResultException;
	public List<Result> getResult(String userName) throws ResultException;
	public Result addNewResult(Result result) throws ResultException;
	

}
