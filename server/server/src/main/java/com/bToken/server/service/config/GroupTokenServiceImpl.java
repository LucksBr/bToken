package com.bToken.server.service.config;

import java.util.Date;

import com.bToken.server.model.GroupToken;
import com.bToken.server.repository.interfaces.GroupTokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.GroupTokenService;
import com.bToken.server.service.validation.ServiceException;

public class GroupTokenServiceImpl extends AbstractCrudService<GroupToken, Integer> implements GroupTokenService  {

    public GroupTokenServiceImpl(GroupTokenRepository repository) {
        super(repository);

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
            new ValidatorField("name","O nome deve ser informado!"),
            new ValidatorField("description","A descrição deve ser informada!"),
            new ValidatorField("dateCreation","A data de criação deve ser informada!"),
            new ValidatorField("user","O usuário criador deve ser informado!")
        ));
    }

    @Override
    public void beforeSave(GroupToken entity) throws ServiceException {
        entity.setDateCreation(new Date());
    }
    
}
