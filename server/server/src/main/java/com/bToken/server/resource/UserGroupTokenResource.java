package com.bToken.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.UserGroupToken;
import com.bToken.server.service.interfaces.UserGroupTokenService;

@RestController
@RequestMapping("/user-group-token")
public class UserGroupTokenResource extends AbstractCrudResource<UserGroupToken,Integer> {

    public UserGroupTokenResource(UserGroupTokenService userGroupTokenService) {
        super(userGroupTokenService);
    }
    
}
