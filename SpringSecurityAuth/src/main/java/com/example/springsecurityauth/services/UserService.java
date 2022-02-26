package com.example.springsecurityauth.services;

import com.example.springsecurityauth.configs.SecurityConfig;
import com.example.springsecurityauth.entities.Role;
import com.example.springsecurityauth.entities.User;
import com.example.springsecurityauth.repositories.UserRepository;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired      //прибить, если что
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void register(User user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        userRepository.save(newUser);
    }

    private void encodePassword(User source, User target){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }

    private boolean checkIfUserExist(String username){
        return userRepository.findByUsername(username) != null ? true : false;
    }

}
