package com.bToken.server.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bToken.server.model.Token;
import com.bToken.server.service.interfaces.TokenService;

@RestController
@RequestMapping("/token")
public class TokenResource extends AbstractCrudResource<Token, Integer> {
    
    public TokenResource(TokenService tokenService) {
        super(tokenService);
    }
    
}
