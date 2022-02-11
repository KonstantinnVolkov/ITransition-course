package com.example.task3.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "regDate")
    private String regDate;
    @Column(name = "loginDate")
    private String loginDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
