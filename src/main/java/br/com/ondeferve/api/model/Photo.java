package br.com.ondeferve.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ondeferve.api.model.Event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Table(name = "photo")
@Entity
public class Photo extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "url", length = 255)
    private String url;

    @OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "photo")	
    private List<Event> events;
    

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

    
}