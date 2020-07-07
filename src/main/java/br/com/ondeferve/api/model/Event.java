package br.com.ondeferve.api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "event")
@Entity
public class Event extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "user")	
    private List<Confirmation> confirmations;
  
    @OneToMany(cascade = CascadeType.ALL, 
          mappedBy = "photo")	
    private List<Photo> photos;


    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "banner")
    private String banner;
        
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "lat")
    private BigDecimal lat;
      
    @Column(name = "lng")
    private BigDecimal lng;

    public Event() {
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getLocation() {
      return this.location;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public String getDescription() {
      return this.description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getBanner() {
      return this.banner;
    }

    public void setBanner(String banner) {
      this.banner = banner;
    }

    public Date getDate() {
      return this.date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public BigDecimal getLat() {
      return this.lat;
    }

    public void setLat(BigDecimal lat) {
      this.lat = lat;
    }

    public BigDecimal getLng() {
      return this.lng;
    }

    public void setLng(BigDecimal lng) {
      this.lng = lng;
    }

    @JsonIgnore
    public User getUser() {
      return user;
    }

    @JsonProperty
    public void setUser(User user) {
      this.user = user;
    }

    @JsonIgnore
    public List<Photo> getPhotos() {
      return photos;
    }

    @JsonProperty
    public void setPhotos(List<Photo> photos) {
      this.photos = photos;
    }

    public List<Confirmation> getConfirmations() {
      return confirmations;
    }

    @JsonProperty
    public void setConfirmations(List<Confirmation> confirmations) {
      this.confirmations = confirmations;
    }

}