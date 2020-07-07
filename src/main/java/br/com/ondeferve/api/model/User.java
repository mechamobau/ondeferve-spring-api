package br.com.ondeferve.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Table(name = "user")
@Entity
public class User extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", length = 120)
    private String name;
    @Column(name = "username", length = 60, unique = true)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 60)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "user")	
    private List<Event> events;
    
    @OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "user")	
	private List<Confirmation> confirmations;

    public User() {
    }

    public User(Long id) {
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUserusername(String username) {
        this.username = username;
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

    @JsonIgnore
	public List<Event> getEvents() {
		return events;
	}

	@JsonProperty
	public void setEvents(List<Event> events) {
		this.events = events;
    }
    
    @JsonIgnore
	public List<Confirmation> getConfirmations() {
		return confirmations;
	}

	@JsonProperty
	public void setConfirmations(List<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}
}