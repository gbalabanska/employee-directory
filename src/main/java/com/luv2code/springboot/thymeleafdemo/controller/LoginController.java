package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/sign-up")
    public String showSignInPage() {
        return "sign-up";
    }
}










