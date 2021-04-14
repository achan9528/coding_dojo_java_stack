package com.codingdojo.qa.models;
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

import com.codingdojo.qa.models.*;

import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 1, max = 255)
	private String subject;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "questions_tags",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn(name="tag_id")
	)
	private List<Question> questions;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDate.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDate.now();
	}
	
	public Tag() {
	}
	
	public Tag(String subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
