package br.com.ondeferve.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "confirmation")
@Entity
public class Confirmation extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Confirmation() {
    }

    public Confirmation(Long id) {
        setId(id);
    }

    public User getUser() {
        return user;
    }

    @JsonProperty
    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonIgnore
    public Event getEvent() {
        return event;
    }

    @JsonProperty
    public void setEvent(Event event) {
        this.event = event;
    }
}