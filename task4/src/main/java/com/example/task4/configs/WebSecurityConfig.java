package com.example.task4.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                    .antMatchers("/", "/login/**", "/registration/**").permitAll()
                    .antMatchers("/im").authenticated()
                .and()
                    .formLogin()
                    .usernameParameter("username")
                    .loginPage("/login")
                    .defaultSuccessUrl("/im")
                .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
