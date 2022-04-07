package com.example.task3.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomLogout customLogout;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder, CustomLogout customLogout) {
        this.passwordEncoder = passwordEncoder;
        this.customLogout = customLogout;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login/**", "/registration/**").permitAll()
                .antMatchers("/table/**").authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .loginPage("/login")
                .defaultSuccessUrl("/table")
                .and()
                .logout()
                .addLogoutHandler(customLogout)
                .logoutSuccessUrl("/login?logout")
                .and()
                .csrf().disable();
    }


}
