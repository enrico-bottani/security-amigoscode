package com.enricobottani.securityamigoscode.controller.api;

import com.enricobottani.securityamigoscode.model.Student;
import com.enricobottani.securityamigoscode.repository.StudentRepository;
import com.enricobottani.securityamigoscode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("oauth-proxy/set-token")
public class OAuthProxyController {
    private final UserService userService;

    @Autowired
    public OAuthProxyController(UserService userService){
        this.userService = userService;
    }
    @PostMapping()
    public boolean setUserPassword(@RequestParam(name = "username") String username,
                                    @RequestParam(name = "token") String token){
        return userService.setUserPassword(username, token);
    }
}
