package com.bToken.server.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bToken.server.model.core.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Integer>  {
    
}
