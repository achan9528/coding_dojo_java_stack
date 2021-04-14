package com.codingdojo.employersandmanagers.services;

import com.codingdojo.employersandmanagers.repositories.*;
import com.codingdojo.employersandmanagers.models.*;
import java.util.List;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private final EmployeeRepository er;
	public EmployeeService(EmployeeRepository er) {
		this.er = er;
	}
	
	public List<Employee> findAll() {
		return er.findAll();
	}
	
	public void create(String fn, String ln, Long mid) {
		Employee e = new Employee(fn, ln);
		e.setManager(er.findById(mid).get());
		er.save(e);
	}
	
	public void showRelationships() {
		Employee e = er.findAll().get(1);
		System.out.println(e.getManager().getFirstName());

		for (Employee em: e.getManager().getEmployees()) {
			System.out.println(em.getFirstName());
		}
	}
}
