package com.bToken.server.service.interfaces;

import com.bToken.server.model.User;
import com.bToken.server.model.request.LoginRequest;
import com.bToken.server.service.validation.ServiceException;

public interface UserService extends BaseCrudServiceInterface<User, Integer>{
    
     String authenticateAndGenarateToken(LoginRequest loginRequest) throws ServiceException;

}