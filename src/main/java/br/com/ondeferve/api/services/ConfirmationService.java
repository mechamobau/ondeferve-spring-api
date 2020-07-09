package br.com.ondeferve.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.model.Confirmation;
import br.com.ondeferve.api.repositories.ConfirmationRepository;

@Service
public class ConfirmationService implements ServiceInterface<Confirmation> {

    @Autowired
    private ConfirmationRepository confirmationRepo;

    public ConfirmationService() {
    }

    public List<Confirmation> listByEvent(Long id) {
        return confirmationRepo.findByEventId(id);
    }

    public Boolean verifyConfirmation(Long event_id, Long user_id) {
        return confirmationRepo.verifyConfirmation(event_id, user_id);
    }

    public Confirmation findConfirmation(Long event_id, Long user_id) {
        return confirmationRepo.findConfirmation(event_id, user_id);
    }

    @Override
    public Confirmation create(Confirmation obj) {
        confirmationRepo.save(obj);
        return obj;
    }

    @Override
    public Confirmation findById(Long id) {
        Optional<Confirmation> _confirmation = confirmationRepo.findById(id);
        return _confirmation.orElse(null);
    }

    @Override
    public List<Confirmation> findAll() {
        return confirmationRepo.findAll();

    }

    @Override
    public boolean update(Confirmation obj) {
        if (confirmationRepo.existsById(obj.getId())) {
            confirmationRepo.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Confirmation> _confirmation = confirmationRepo.findById(id);
        if (_confirmation.isPresent()) {
            confirmationRepo.delete(_confirmation.get());
            return true;
        }
        return false;
    }
}