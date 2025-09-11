package com.bToken.server.service.config;

import com.bToken.server.model.UserToken;
import com.bToken.server.repository.interfaces.UserTokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.UserTokenService;

public class UserTokenServiceImpl extends AbstractCrudService<UserToken, Integer> implements UserTokenService {

    public UserTokenServiceImpl(UserTokenRepository repository) {
        super(repository);

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
            new ValidatorField("dateAcquisition","A data de aquisição do token deve ser informada!"),
            new ValidatorField("userGroupToken","o grupo a qual este token faz parte deve ser informado!"),
            new ValidatorField("token","O token de referência deve ser informado!")
        ));
    }
    
}
