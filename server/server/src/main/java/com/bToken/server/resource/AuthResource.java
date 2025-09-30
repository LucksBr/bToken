package com.bToken.server.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.request.LoginRequest;
import com.bToken.server.service.interfaces.UserService;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    private final UserService userService;

    public AuthResource(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return userService.authenticateAndGenarateToken(loginRequest);
    }
}
