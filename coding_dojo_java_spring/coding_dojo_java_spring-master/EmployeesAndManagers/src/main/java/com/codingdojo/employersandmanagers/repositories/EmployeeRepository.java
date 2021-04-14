package com.codingdojo.employersandmanagers.repositories;

import java.util.List;
import com.codingdojo.employersandmanagers.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	List<Employee> findAll();
}
