package com.codingdojo.relationships.services;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
	private final LicenseRepository lR;
	
	public LicenseService(LicenseRepository lR) {
		this.lR = lR;
	}
	
	public List<License> allLicenses(){
		return lR.findAll();
	}
	
	public License createLicense(License l) {
		return lR.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = lR.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public void deleteLicense(Long id) {
		lR.deleteById(id);
	}
	
	public License updatePerson(Long id, String number,
			Date expirationDate, String state,
			Person person) {
		License l = findLicense(id);
		l.setNumber(number);
		l.setExpirationDate(expirationDate);
		l.setState(state);
		l.setPerson(person);
		return l;
	}
}
