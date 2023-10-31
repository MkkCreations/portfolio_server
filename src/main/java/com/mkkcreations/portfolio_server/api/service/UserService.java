package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.User;
import com.mkkcreations.portfolio_server.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LogService logService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user id not found"));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }

    public User update(User user, User newUser) {
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setImage(newUser.getImage());
        user.setBio(newUser.getBio());
        user.setResume(newUser.getResume());
        user.setLocation(newUser.getLocation());
        user.setGithub(newUser.getGithub());
        user.setLinkedin(newUser.getLinkedin());
        user.setNumber(newUser.getNumber());
        logService.createLog("User", String.format("User %s updated info", user.getUsername()));
        return userRepository.save(user);
    }

    public User create(User user) {
        return userRepository.save(user);
    }
}
