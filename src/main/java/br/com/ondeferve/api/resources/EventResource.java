package br.com.ondeferve.api.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import br.com.ondeferve.api.model.Event;
import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.services.EventService;
import br.com.ondeferve.api.services.UserService;

@RestController
@RequestMapping("/events")
public class EventResource implements ResourceInterface<Event> {

    @Autowired
    private EventService events;

    @Autowired
    private UserService users;

    public EventResource() {
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Event>> get() {
        return ResponseEntity.ok(events.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Event _event = events.findById(id);
        if (_event != null) {
            return ResponseEntity.ok(_event);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Event> post(@RequestBody Event obj, HttpServletRequest req) {
        User user = users.whoami(req);
        obj.setUser(user);
        events.create(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Event obj) {
        if (events.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (events.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<Event> post(Event obj) {
        // TODO Auto-generated method stub
        return null;
    }

}