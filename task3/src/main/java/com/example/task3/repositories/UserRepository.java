package com.example.task3.repositories;

import com.example.task3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
