package com.bToken.server.service.config;

import org.springframework.stereotype.Service;

import com.bToken.server.model.Token;
import com.bToken.server.repository.interfaces.TokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.TokenService;

@Service
public class TokenServiceImpl extends AbstractCrudService<Token, Integer> implements TokenService {

    public TokenServiceImpl(TokenRepository repository) {
        super(repository);
        
        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(), 
            new ValidatorField("name","O nome deve ser informado!"),
            new ValidatorField("description","A descrição deve ser informada!"),
            new ValidatorField("dateCreation","A data de criação deve ser informada!"),
            new ValidatorField("groupToken","O grupo deste token deve ser informado!"),
            new ValidatorField("imageFile","A imagem deste token deve ser informada!")
        ));
    }

}