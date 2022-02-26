package com.example.tests.services;

import com.example.tests.details.UserDetailsImpl;
import com.example.tests.models.User;
import com.example.tests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null){
            throw  new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new UserDetailsImpl(user);
    }
}
