package br.com.ondeferve.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.repositories.UserRepository;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private UserRepository userRepo;

    public UserService() {
    }

    @Override
    public User create(User obj) {
        userRepo.save(obj);
        return obj;
    }

    @Override
    public User findById(Long id) {
        Optional<User> _user = userRepo.findById(id);
        return _user.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();

    }

    @Override
    public boolean update(User obj) {
        if (userRepo.existsById(obj.getId())) {
            userRepo.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> _user = userRepo.findById(id);
        if (_user.isPresent()) {
            userRepo.delete(_user.get());
            return true;
        }
        return false;
    }
}