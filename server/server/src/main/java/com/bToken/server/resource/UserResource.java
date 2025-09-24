package com.bToken.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.User;
import com.bToken.server.service.interfaces.UserService;


@RestController
@RequestMapping("/user")
public class UserResource extends AbstractCrudResource<User,Integer> {

    public UserResource(UserService userService) {
        super(userService);
    }
    
}
