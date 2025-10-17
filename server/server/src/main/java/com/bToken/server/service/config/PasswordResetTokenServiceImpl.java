package com.bToken.server.service.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import com.bToken.server.model.User;
import com.bToken.server.model.core.PasswordResetToken;
import com.bToken.server.repository.interfaces.PasswordResetTokenRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.UserService;

public class PasswordResetTokenServiceImpl extends AbstractCrudService<PasswordResetToken, Integer> {

    private final Integer TIME_TO_USE_TOKEN = 20;

    private final UserService userService;

    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository,
                                         UserService userService
    ) {
        super(passwordResetTokenRepository);
        this.userService = userService;
        this.setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
            new ValidatorField("token")
        ));
    }


    public void create(String email){
        Optional<User> userSearchedByEmail = userService.findByEmail(email);

        if(userSearchedByEmail.isPresent()){
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setToken(UUID.randomUUID().toString());
            passwordResetToken.setUser(userSearchedByEmail.get());
            passwordResetToken.setExpirationDate(Date.from(Instant.now().plus(TIME_TO_USE_TOKEN, ChronoUnit.MINUTES)));
            passwordResetToken.setUsed(false);

            save(passwordResetToken);
        }
    }
    
}
