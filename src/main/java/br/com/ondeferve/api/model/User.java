package br.com.ondeferve.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

@Table(name = "users")
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

    public void Usuario() {
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