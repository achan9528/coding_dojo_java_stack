package com.codingdojo.events.models;

//Java stuff
import java.time.LocalDate;
import java.util.List;
//Spring Data Stuff
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
//Spring Validation Stuff
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
//User stuff
import com.codingdojo.events.models.*;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Email(message="Email must be valid")
    private String email;
    @Size(min=5, message="Password must be at least 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
	@NotNull
	@Size(min=1, max=255)
    private String firstName;
	@NotNull
	@Size(min=1, max=255)
	private String lastName;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@Column(updatable=false)
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> eventsHosted;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_eventsAttended",
			joinColumns=@JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<Event> eventsAttended;
	
    @PrePersist
    private void onCreate() {
    	this.createdAt = LocalDate.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = LocalDate.now();
    }
    
    public User(){
    }
    
    public User(String email, String password,
    		String firstName, String lastName,
    		String city, String state) {
    	this.email = email;
    	this.password = password;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.city = city;
    	this.state = state;
    }



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Event> getEventsHosted() {
		return eventsHosted;
	}

	public void setEventsHosted(List<Event> eventsHosted) {
		this.eventsHosted = eventsHosted;
	}

	public List<Event> getEventsAttended() {
		return eventsAttended;
	}

	public void setEventsAttended(List<Event> eventsAttended) {
		this.eventsAttended = eventsAttended;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
