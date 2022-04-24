package com.example.task4.service;

import com.example.task4.entities.User;
import com.example.task4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUsers(List<Integer> IDs) {
        for (Integer id : IDs) {
            Optional<User> usersOptional = userRepository.findById(id);
            if (usersOptional.isPresent()) {
                userRepository.delete(usersOptional.get());
            }
            else {
                throw new RuntimeException("Post for id " + IDs + " not found!");
            }
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void setLastLoginTime(int id) {
        userRepository.updateUserLastLogin(id, new Date());
    }
}
