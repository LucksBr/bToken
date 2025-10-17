package com.bToken.server.service.interfaces;

import com.bToken.server.model.core.PasswordResetToken;

public interface PasswordResetTokenServiceInterface extends BaseCrudServiceInterface<PasswordResetToken, Integer> {
    
    void create(String email);

}