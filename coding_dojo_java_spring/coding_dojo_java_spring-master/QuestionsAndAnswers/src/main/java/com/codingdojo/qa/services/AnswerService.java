package com.codingdojo.qa.services;
import com.codingdojo.qa.repositories.AnswerRepository;
import com.codingdojo.qa.models.*;

//Other Java classes needed
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
	private final AnswerRepository ar;
	public AnswerService(AnswerRepository ar) {
		this.ar = ar;
	}
	
	public List<Answer> findAll(){
		return ar.findAll();
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> optionalAnswer = ar.findById(id);
		if (optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
	
	public Answer createAnswer(Answer a) {
		System.out.println("This is the answer submitted:");
		return ar.save(a);
	}
}
