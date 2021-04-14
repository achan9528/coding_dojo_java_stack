package com.codingdojo.dojosandninjas.models;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

import com.codingdojo.dojosandninjas.models.Dojo;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max=200)
    private String firstName;
    @Size(min = 3, max=200)
    private String lastName;
    private int age;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
 
    @PrePersist
    private void onCreate() {
    	this.createdAt = LocalDate.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = LocalDate.now();
    }
    
    public Ninja() {}
    
    public Ninja(String firstName, String lastName,
    		int age, Dojo dojo) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.dojo = dojo;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
}
