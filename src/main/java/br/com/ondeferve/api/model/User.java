package br.com.ondeferve.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

@Table(name = "user")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    public User() {
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

}