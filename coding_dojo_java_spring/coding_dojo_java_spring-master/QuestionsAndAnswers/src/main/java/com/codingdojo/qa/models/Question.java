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
import javax.validation.constraints.Pattern;
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
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 1, max = 255)
	private String question;
	@Pattern(regexp="^[-\\w\\s]+(?:,[-\\w\\s]*)*$")
	private String tagString;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "questions_tags",
			joinColumns=@JoinColumn(name="tag_id"),
			inverseJoinColumns=@JoinColumn(name="question_id")
	)
	private List<Tag> tags;
	
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers;
	
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question() {
	}
	
	public Question(String question) {
		this.question = question;
	}

	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
}
