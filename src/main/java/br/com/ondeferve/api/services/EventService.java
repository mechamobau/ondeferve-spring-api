package br.com.ondeferve.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.model.Event;
import br.com.ondeferve.api.repositories.EventRepository;

@Service
public class EventService implements ServiceInterface<Event> {

    @Autowired
    private EventRepository EventRepo;

    public EventService() {
    }

    @Override
    public Event create(Event obj) {
        Date d = new Date();
        obj.setDate(d);
        EventRepo.save(obj);
        return obj;
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> _Event = EventRepo.findById(id);
        return _Event.orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return EventRepo.findAll();

    }

    @Override
    public boolean update(Event obj) {
        if (EventRepo.existsById(obj.getId())) {
            EventRepo.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Event> _Event = EventRepo.findById(id);
        if (_Event.isPresent()) {
            EventRepo.delete(_Event.get());
            return true;
        }
        return false;
    }
}