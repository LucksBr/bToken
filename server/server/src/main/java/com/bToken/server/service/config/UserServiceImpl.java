package com.bToken.server.service.config;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bToken.server.model.User;
import com.bToken.server.repository.interfaces.UserCrudRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.UserService;
import com.bToken.server.service.validation.ServiceException;

public class UserServiceImpl extends AbstractCrudService<User, Integer> implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserCrudRepository mainRepository;

    public UserServiceImpl(UserCrudRepository repository) {
        super(repository);
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.mainRepository = repository;

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(), 
            new ValidatorField("name","O nome do usuário deve ser informado!"),
            new ValidatorField("email","O email do usuário deve ser informado!"),
            new ValidatorField("password","A senha do usuário deve ser informada!")
        ));
    }

    @Override
    public void beforeSave(User entity) throws ServiceException {
        entity.setDateCreation(new Date());

        String hashedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(hashedPassword);

        super.beforeSave(entity);
    }
    
    public Boolean authenticate(String email, String nativePassword) throws ServiceException {
        User userFound =  mainRepository.findByEmail(email)
                            .orElseThrow(() -> new ServiceException("Nenhuma conta foi encontrada para o email informado"));
        
        return passwordEncoder.matches(nativePassword, userFound.getPassword());
    }
    
}
