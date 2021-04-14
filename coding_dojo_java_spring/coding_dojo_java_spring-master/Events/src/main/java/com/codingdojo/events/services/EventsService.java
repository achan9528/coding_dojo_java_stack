package com.codingdojo.events.services;
//Web stuff
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.codingdojo.events.models.*;
import com.codingdojo.events.repositories.*;
//Java stuff
import java.util.List;

@Service
public class EventsService {
	private final UserRepository ur;
	private final EventRepository er;
	private final MessageRepository mr;
	
	public EventsService(UserRepository ur,
			EventRepository er, MessageRepository mr) {
		this.ur = ur;
		this.er = er;
		this.mr = mr;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return ur.save(user);
	}
	
	public User findById(Long id) {
		Optional<User> u = ur.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	public User findByEmail(String s) {
		return ur.findByEmail(s);
	}
	
	public boolean authenticateUser(String email, String password) {
		User u = ur.findByEmail(email);
		if (u==null) {
			return false;
		} else {
			if (BCrypt.checkpw(password,u.getPassword())){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public List<Event> findEventsInState(String state){
		return er.findByStateIs(state);
	}
	
	public List<Event> findEventsOutOfState(String state){
		return er.findByStateNot(state);
	}
	
	public Event createEvent(Event e) {
		return er.save(e);
	}
	
	public Event findEventById(Long id) {
		Optional<Event> e = er.findById(id);
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public void deleteEvent(Long id) {
		er.deleteById(id);
	}
	
	public void updateEvent(Event previous, Event updated) {
		previous.setName(updated.getName());
		previous.setEventDate(updated.getEventDate());
		previous.setCity(updated.getCity());
		previous.setState(updated.getState());
		er.save(previous);
	}
	
	public void joinEvent(User u, Event e) {
		List<Event> eventsAttended = u.getEventsAttended();
		eventsAttended.add(e);
		u.setEventsAttended(eventsAttended);
		ur.save(u);
	}
	
	public Message createMessage(Message m) {
		
		return mr.save(m);
	}
}
