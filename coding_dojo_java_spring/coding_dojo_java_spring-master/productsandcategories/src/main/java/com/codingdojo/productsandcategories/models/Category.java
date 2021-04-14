package com.codingdojo.productsandcategories.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
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
import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

import com.codingdojo.productsandcategories.models.Product;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@NotNull
	@Size(min = 1, max = 200)
	private String name;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "categories_products",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="category_id")
	)
	private List<Product> products;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDate.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDate.now();
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
