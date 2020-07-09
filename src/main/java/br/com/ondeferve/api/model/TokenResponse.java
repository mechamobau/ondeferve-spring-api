package br.com.ondeferve.api.model;

import java.io.Serializable;

public class TokenResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private User user;
    private String token;

    public TokenResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}