package com.bToken.server.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bToken.server.model.UserGroupToken;

@Repository
public interface UserGroupTokenRepository extends JpaRepository<UserGroupToken,Integer> {
    
}
