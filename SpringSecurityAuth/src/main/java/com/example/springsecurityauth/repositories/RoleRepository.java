package com.example.springsecurityauth.repositories;

import com.example.springsecurityauth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
}
