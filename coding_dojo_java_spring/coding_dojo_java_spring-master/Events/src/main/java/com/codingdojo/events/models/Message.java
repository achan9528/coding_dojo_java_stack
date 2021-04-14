package com.codingdojo.events.models;

//Java stuff
import java.time.LocalDate;
import java.util.List;
//Spring Data Stuff
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//Spring Validation Stuff
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
//User stuff
import com.codingdojo.events.models.*;

@Entity
@Table(name="messages")
public class Message {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String message;
	@Column(updatable=false)
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User author;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event event;
	
    @PrePersist
    private void onCreate() {
    	this.createdAt = LocalDate.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = LocalDate.now();
    }
    
    public Message() {}
    public Message(String message,
    		User author, Event event) {
    	this.message = message;
    	this.author = author;
    	this.event = event;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
