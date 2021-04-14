package com.codingdojo.relationships.services;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
	private final PersonRepository pR;
	
	public PersonService(PersonRepository personRepo) {
		this.pR = personRepo;
	}
	
	public List<Person> allPersons(){
		return pR.findAll();
	}
	
	public Person createPerson(Person p) {
		return pR.save(p);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = pR.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	public void deletePerson(Long id) {
		pR.deleteById(id);
	}
	
	public Person updatePerson(Long id, String firstName,
			String lastName, License license) {
		Person p = findPerson(id);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setLicense(license);
		pR.save(p);
		return p;
	}
}
