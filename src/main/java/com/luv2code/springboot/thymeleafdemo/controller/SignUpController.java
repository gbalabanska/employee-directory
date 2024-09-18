package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/process-signup")
    public String processSignUp(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = "{bcrypt}" + passwordEncoder.encode(password);
        // insert user into the database
        String insertUserQuery = "INSERT INTO members (user_id, pw, active) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertUserQuery, username, encodedPassword, true);


        // assign default role USER
        String insertRoleQuery = "INSERT INTO roles (user_id, role) VALUES (?, ?)";
        jdbcTemplate.update(insertRoleQuery, username, "ROLE_USER");

        // redirect to login page
        return "redirect:/showMyLoginPage";
    }
}
