package com.codingdojo.languages.services;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allBooks(){
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		langRepo.deleteById(id);
	}
	
	public Language updateLang(Long id, String name,
			String creator, String currentVersion) {
		Language l = findLang(id);
		l.setName(name);
		l.setCreator(creator);
		l.setCurrentVersion(currentVersion);
		langRepo.save(l);
		return l;
	}
	
}
