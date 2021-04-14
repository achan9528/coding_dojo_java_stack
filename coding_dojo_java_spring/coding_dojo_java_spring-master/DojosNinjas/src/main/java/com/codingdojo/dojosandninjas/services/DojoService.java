package com.codingdojo.dojosandninjas.services;

import com.codingdojo.dojosandninjas.models.*;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

import org.springframework.stereotype.Service;

import java.security.spec.DSAGenParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
	private final DojoRepository dR;
	
	public DojoService (DojoRepository dR) {
		this.dR = dR;
	}
	
	public List<Dojo> findAll(){
		return dR.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dR.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dR.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
