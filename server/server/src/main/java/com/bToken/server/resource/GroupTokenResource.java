package com.bToken.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.GroupToken;
import com.bToken.server.service.interfaces.GroupTokenService;

@RestController
@RequestMapping("/group-token")
public class GroupTokenResource extends AbstractCrudResource<GroupToken, Integer> {

    public GroupTokenResource(GroupTokenService groupTokenService) {
        super(groupTokenService);
    }
    
}
