package br.com.ondeferve.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Table(name = "photo")
@Entity
public class Photo extends AbstractEntity {
    private static final long serialVersionUID = 1L;


    @OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "photo")	
    private List<Event> events;
    

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

    
}