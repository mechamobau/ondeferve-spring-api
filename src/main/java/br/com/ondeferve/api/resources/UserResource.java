package br.com.ondeferve.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ondeferve.api.model.Credentials;
import br.com.ondeferve.api.model.TokenResponse;
import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource implements ResourceInterface<User> {

    @Autowired
    private UserService users;

    public UserResource() {
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<TokenResponse> signUp(@RequestBody Credentials credentials) {
        String token = users.signin(credentials.getUsername(), credentials.getPassword());

        if (token != null) {
            User user = users.findByUsername(credentials.getUsername());

            TokenResponse response = new TokenResponse(token, user);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<TokenResponse> signUp(@RequestBody User user) {
        String token = users.signup(user);

        if (token != null) {

            TokenResponse response = new TokenResponse(token, user);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<User>> get() {
        return ResponseEntity.ok(users.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        User _user = users.findById(id);
        if (_user != null) {
            return ResponseEntity.ok(_user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<User> post(@RequestBody User obj) {
        users.create(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody User obj) {
        if (users.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (users.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}