package com.codingdojo.qa.services;

import com.codingdojo.qa.repositories.QuestionRepository;
import com.codingdojo.qa.services.*;
import com.codingdojo.qa.models.*;

//Other Java classes needed
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	private final QuestionRepository qr;
	private final TagService ts;
	
	public QuestionService(QuestionRepository qr, TagService ts) {
		this.qr = qr;
		this.ts = ts;
	}
	
	public List<Question> findAll(){
		return qr.findAll();
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = qr.findById(id);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public Question createQuestion(Question q) {
		Question newQ = qr.save(q);
		String[] tagNames = newQ.getTagString().split(",");
		System.out.println(tagNames);
		for (int i = 0; i<tagNames.length; i++) {
			Tag temp = new Tag(tagNames[i]);
			System.out.println(tagNames[i]);
			Tag newTag = ts.createTag(temp);
			addTag(newQ, newTag);
		}
		return newQ;
	}
	
	public Question addTag(Question q, Tag t) {
		List<Tag> qt = q.getTags();
		if (qt == null) {
			qt = new ArrayList<Tag>();
		}
		qt.add(t);
		q.setTags(qt);
		return qr.save(q);
	}
	
	public Question addAnswer(Question q, Answer a) {
		System.out.println("This is the id: " + q.getId());
		System.out.println("These are the answers: " + q.getAnswers());
		
		List<Answer> qa = q.getAnswers();
		qa.add(a);
		q.setAnswers(qa);
		
		System.out.println("These are the answers after: " + q.getAnswers());
		Question n = qr.save(q);
		System.out.println("These are the answers of n: " + n.getAnswers());
		return qr.save(q);
	}
}
