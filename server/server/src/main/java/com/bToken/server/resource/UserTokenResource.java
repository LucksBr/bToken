package com.bToken.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.UserToken;
import com.bToken.server.service.interfaces.UserTokenService;


@RestController
@RequestMapping("/user-token")
public class UserTokenResource extends AbstractCrudResource<UserToken, Integer> {

    public UserTokenResource(UserTokenService userTokenService) {
        super(userTokenService);
    }
    
}
