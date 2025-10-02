package com.bToken.server.resource;

import com.bToken.server.model.QrCode;
import com.bToken.server.service.interfaces.QrCodeService;

public class QrCodeResource extends AbstractCrudResource<QrCode,Integer> {

    public QrCodeResource(QrCodeService qrCodeService) {
        super(qrCodeService);
    }
    
}
