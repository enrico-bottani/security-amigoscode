package com.enricobottani.securityamigoscode.controller.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class AuthenticationController {
    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
}
