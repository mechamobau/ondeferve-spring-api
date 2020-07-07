package br.com.ondeferve.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "event")
@Entity
public class Event extends AbstractEntity {
    private static final long serialVersionUID = 1L;

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


}