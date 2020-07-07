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

import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource implements ResourceInterface<User> {

    @Autowired
    private UserService users;

    public UserResource() {
    }

    @Override
    public ResponseEntity<List<User>> get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<User> post(User obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> put(User obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}