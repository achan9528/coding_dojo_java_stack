package com.codingdojo.countries.services;

import com.codingdojo.countries.repositories.*;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	private final CountryRepository cr;
	private final LanguageRepository lr;
	private final CityRepository ctr;
	public CountryService(CountryRepository cr,
			LanguageRepository lr, CityRepository ctr) {
		this.cr = cr;
		this.lr = lr;
		this.ctr = ctr;
	}
	
	public List<Object[]> join1(){
		return cr.join1();
	}
	
	public List<Object[]> join2(){
		return cr.join2();
	}
	
	public List<Object[]> join3(){
		return cr.join3();
	}
	
	public List<Object[]> join4(){
		return cr.join4();
	}
	
	public List<Object[]> join5(){
		return cr.join5();
	}
	
	public List<Object[]> join6(){
		return cr.join6();
	}
	
	public List<Object[]> join7(){
		return cr.join7();
	}
	
	public List<Object[]> join8(){
		return cr.join8();
	}
}