package com.codingdojo.employersandmanagers.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
	public Employee() {
		
	}
	public Employee(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_manager", 
        joinColumns = @JoinColumn(name = "employee_id"), 
        inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    private Employee manager;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_manager", 
        joinColumns = @JoinColumn(name = "manager_id"), 
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;
    
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee manager) {
        this.manager = manager;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}     
}
