package com.bToken.server.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bToken.server.model.QrCode;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode,Integer> {
    
}
