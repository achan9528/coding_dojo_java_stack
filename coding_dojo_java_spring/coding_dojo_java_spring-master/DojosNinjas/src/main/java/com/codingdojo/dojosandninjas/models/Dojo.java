package com.codingdojo.dojosandninjas.models;

import java.time.LocalDate;
import java.util.List;
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

import com.codingdojo.dojosandninjas.models.Ninja;

@Entity
@Table(name="dojos")
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max=200)
    private String name;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate updatedAt;
    
    @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
    private List<Ninja> ninjas;
 
    @PrePersist
    private void onCreate() {
    	this.createdAt = LocalDate.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = LocalDate.now();
    }
    
    public Dojo() {
        
    }
    
    public Dojo(String name) {
    	this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
}
