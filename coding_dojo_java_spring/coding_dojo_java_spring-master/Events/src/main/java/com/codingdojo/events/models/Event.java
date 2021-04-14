package com.codingdojo.events.models;

// Java stuff
import java.util.Date;
import java.util.List;
// Spring Data Stuff
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
import org.springframework.format.annotation.DateTimeFormat;
// Spring Validation Stuff
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
// User stuff
import com.codingdojo.events.models.*;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=1, max=255)
    private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date eventDate;
	private String city;
	private String state;
	private int numAttendees;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_eventsAttended",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="event_id")
	)
	private List<User> attendees;
	
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
	private List<Message> messages;
	
    @PrePersist
    private void onCreate() {
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }

    public Event() {}
    public Event(String name, Date eventDate,
    		String city, String state, User host, 
    		List<User> attendees) {
    	this.name = name;
    	this.eventDate = eventDate;
    	this.city = city;
    	this.state = state;
    	this.host = host;
    	this.attendees = attendees;
    }
    


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNumAttendees() {
		return numAttendees;
	}

	public void setNumAttendees(int numAttendees) {
		this.numAttendees = numAttendees;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
