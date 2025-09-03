package com.bToken.server.service.config;

import com.bToken.server.model.UserGroupToken;
import com.bToken.server.repository.interfaces.UserGroupTokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.UserGroupTokenService;

public class UserGroupTokenServiceImpl extends AbstractCrudService<UserGroupToken, Integer> implements UserGroupTokenService {

    public UserGroupTokenServiceImpl(UserGroupTokenRepository repository) {
        super(repository);

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
             new ValidatorField("user","O usuário deve ser informado!"),
             new ValidatorField("groupToken","O grupo deve ser informado!")
        ));
    }
    
}
