package com.bToken.server.resource;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bToken.server.model.core.PasswordResetToken;
import com.bToken.server.service.interfaces.PasswordResetTokenServiceInterface;

public class PasswordResetTokenResource extends AbstractCrudResource<PasswordResetToken,Integer> {

    public PasswordResetTokenResource(PasswordResetTokenServiceInterface service) {
        super(service);
    }

    @Override
    public PasswordResetTokenServiceInterface getService() {
        return (PasswordResetTokenServiceInterface) super.getService();
    }

    @PostMapping("/request-password-reset")
    public ResponseEntity<?> requestPasswordReset(@RequestParam String email){
        getService().create(email);

        return ResponseEntity.ok(
            Map.of("message", "Se o email informado estiver cadastrado, enviaremos um link para redefinir sua senha.")
        );
    }
    
}
