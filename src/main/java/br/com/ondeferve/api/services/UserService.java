package br.com.ondeferve.api.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ondeferve.api.Security.JwtTokenProvider;
import br.com.ondeferve.api.exception.CustomException;
import br.com.ondeferve.api.model.User;
import br.com.ondeferve.api.model.Role;
import br.com.ondeferve.api.repositories.UserRepository;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private UserRepository userRepo;

    public UserService() {
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password) {                
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.OK);
        }
    }

    public String signup(User user) {

        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
            userRepository.save(user);

            String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());            

            return token;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.OK);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.OK);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
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