package br.com.ondeferve.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Table(name = "photo")
@Entity
public class Photo extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @Column(name = "url", length = 255)
    private String url;

    public Photo() {
    }

    public Photo(Long id) {
        setId(id);
    }

    public String getUrl() {
      return this.url;
    }

    public void setUrl(String url) {
      this.url = url;
    }


    @JsonIgnore
    public Event getEvents() {
      return event;
    }

    @JsonProperty
    public void setEvents(Event event) {
      this.event = event;
    }
    
}