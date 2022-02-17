package com.example.springsecurityauth.repositories;

import com.example.springsecurityauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
