package com.example.task3.repositories;

import com.example.task3.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

}
