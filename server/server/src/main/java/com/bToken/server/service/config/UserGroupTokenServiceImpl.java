package com.bToken.server.service.config;

import com.bToken.server.model.UserGroupToken;
import com.bToken.server.repository.interfaces.UserGroupTokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.UserGroupTokenService;
import com.bToken.server.service.interfaces.UserTokenService;
import com.bToken.server.service.utils.CollectionUtils;
import com.bToken.server.service.validation.ServiceException;

public class UserGroupTokenServiceImpl extends AbstractCrudService<UserGroupToken, Integer> implements UserGroupTokenService {

    private final UserTokenService userTokenService;

    public UserGroupTokenServiceImpl(UserGroupTokenRepository repository,UserTokenService userTokenService) {
        super(repository);
        this.userTokenService = userTokenService;

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
             new ValidatorField("user","O usuário deve ser informado!"),
             new ValidatorField("groupToken","O grupo deve ser informado!")
        ));
    }

    @Override
    public void validate(UserGroupToken entity) throws ServiceException {
        super.validate(entity);

        if(CollectionUtils.isEmpty(entity.getUserTokenList())){
            getErrorBuilder().addError("O grupo deve possuir pelo menos um token!");
        }else{
            entity.getUserTokenList().stream().forEach( userToken -> userTokenService.validate(userToken));
        }
    }
    
}
