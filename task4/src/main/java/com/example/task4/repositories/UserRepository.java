package com.example.task4.repositories;

import com.example.task4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update User set lastLogin = :time where id = :id")
    void updateUserLastLogin(@Param("id") int id, @Param("time")Date time);

    User findByUsername(String username);
    List<User> findAllByOrderByIdAsc();
}
