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

import br.com.ondeferve.api.model.Event;
import br.com.ondeferve.api.model.Photo;
import br.com.ondeferve.api.services.EventService;
import br.com.ondeferve.api.services.PhotoService;

@RestController
@RequestMapping("/photos")
public class PhotoResource implements ResourceInterface<Photo> {

    @Autowired
    private PhotoService photos;

    @Autowired
    private EventService events;

    public PhotoResource() {
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Photo>> get() {
        return ResponseEntity.ok(photos.findAll());
    }

    @GetMapping(value = "/event/{id}")
    public ResponseEntity<?> getEventPhotos(@PathVariable("id") Long id) {
        Event e = events.findById(id);

        if (e != null) {
            return ResponseEntity.ok(photos.findByEventId(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
    }

    @PostMapping(value = "/event/{id}")
    public ResponseEntity<?> postPhoto(@PathVariable("id") Long id, @RequestBody Photo obj) {
        Event e = events.findById(id);

        if (e != null) {
            obj.setEvent(e);
            photos.create(obj);
            return ResponseEntity.ok(obj);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Photo _photo = photos.findById(id);
        if (_photo != null) {
            return ResponseEntity.ok(_photo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Photo> post(@RequestBody Photo obj) {
        photos.create(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Photo obj) {
        if (photos.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (photos.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}