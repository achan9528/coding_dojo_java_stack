package com.codingdojo.dojosandninjas.services;
import com.codingdojo.dojosandninjas.models.*;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaServices {
	private final NinjaRepository nR;
	public NinjaServices(NinjaRepository nR) {
		this.nR = nR;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return nR.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = nR.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
