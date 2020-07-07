package br.com.ondeferve.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.repositories.UserRepository;

public class UserService implements ServiceInterface<User> {
    
    @Autowired
    private UserRepository userRepo;
    
    public UserService() {}

    @Override
    public User create(User obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        return false;
    }
}