package com.example.tests.models;

import com.example.tests.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "username", unique = true)
    private String userName;
    @Column(name = "password", unique = true)
    private String password;
    private transient String confirmPassword;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private State state;

    public static User form (UserForm form){
        return User.builder()
                .email(form.getEmail())
                .userName(form.getUserName())
                .password(form.getPassword())
                .confirmPassword(form.getConfirmPassword())
                .build();
    }

}
