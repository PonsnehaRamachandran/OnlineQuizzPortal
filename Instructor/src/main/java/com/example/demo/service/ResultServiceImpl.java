package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Result;
import com.example.demo.exceptions.ResultException;
import com.example.demo.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository resultRepository;

	@Override
	public List<Result> getAllResult() throws ResultException {
		List<Result> results = resultRepository.findAll();
		if (results.size() > 0) {
			return results;
		} else {
			throw new ResultException("No Results exists..");
		}
	}
	

	@Override
	public List<Result> getResult(String userName) throws ResultException {
		List<Result> result = resultRepository.findByUserName(userName);
		if (result.isEmpty()) {
			throw new ResultException("no result Found with userName =" + userName);
		}
		return result;
	}

	@Override
	public Result addNewResult(Result result) throws ResultException {
		if (result.getResultStatus().isEmpty() || result.getResultScore().isEmpty() || result.getTotalMarks().isEmpty()
				|| result.getTotalQuestion().isEmpty() || result.getTotalQuestion().isEmpty()) {
			throw new ResultException("input field is empty");
		}

		return resultRepository.save(result);
	}

}
