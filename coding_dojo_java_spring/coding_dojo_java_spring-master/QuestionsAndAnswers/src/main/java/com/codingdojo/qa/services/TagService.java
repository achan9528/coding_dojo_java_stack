package com.codingdojo.qa.services;

import com.codingdojo.qa.repositories.TagRepository;
import com.codingdojo.qa.models.*;

//Other Java classes needed
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TagService {
	public final TagRepository tr;
	public TagService(TagRepository tr) {
		this.tr = tr;
	}
	
	public List<Tag> findAll(){
		return tr.findAll();
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> optionalTag = tr.findById(id);
		if (optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
	public Tag createTag(Tag t) {
		String s = t.getSubject();
		if (tr.findBySubjectIs(s).size() == 0) {
			return tr.save(t);
		} else {
			Tag existingTag = tr.findBySubjectIs(s).get(0);
			System.out.println(existingTag.getId());
			return existingTag;
		}
	}
}
