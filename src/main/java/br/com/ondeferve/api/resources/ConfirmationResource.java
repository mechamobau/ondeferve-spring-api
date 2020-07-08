package br.com.ondeferve.api.resources;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
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

import br.com.ondeferve.api.model.Confirmation;
import br.com.ondeferve.api.model.Event;
import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.services.ConfirmationService;
import br.com.ondeferve.api.services.EventService;
import br.com.ondeferve.api.services.UserService;

@RestController
@RequestMapping("/confirmations")
public class ConfirmationResource implements ResourceInterface<Confirmation> {

    @Autowired
    private ConfirmationService confirmations;

    @Autowired
    private EventService events;

    @Autowired
    private UserService users;

    public ConfirmationResource() {
    }

    @GetMapping(value = "/event/{id}")
    public ResponseEntity<?> getByEventId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(confirmations.listByEvent(id));
    }

    @PostMapping(value = "/event/{id}")
    public ResponseEntity<Confirmation> post(@PathVariable("id") Long id, HttpServletRequest req) {
        Event e = events.findById(id);

        if (e != null) {
            User u = users.whoami(req);

            boolean isConfirmed = confirmations.verifyConfirmation(id, u.getId());

            if (!isConfirmed) {
                Date d = new Date();
                Confirmation c = new Confirmation();
                c.setEvent(e);
                c.setUser(u);
                c.setDate(d);

                confirmations.create(c);
                return ResponseEntity.ok(c);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Confirmation>> get() {
        return ResponseEntity.ok(confirmations.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Confirmation _confirmation = confirmations.findById(id);
        if (_confirmation != null) {
            return ResponseEntity.ok(_confirmation);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Confirmation> post(@RequestBody Confirmation obj) {
        confirmations.create(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Confirmation obj) {
        if (confirmations.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (confirmations.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}