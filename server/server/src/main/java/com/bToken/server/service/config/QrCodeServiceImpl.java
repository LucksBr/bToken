package com.bToken.server.service.config;

import com.bToken.server.model.QrCode;
import com.bToken.server.repository.interfaces.QrCodeRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;
import com.bToken.server.service.interfaces.QrCodeService;

public class QrCodeServiceImpl extends AbstractCrudService<QrCode, Integer> implements QrCodeService {

    public QrCodeServiceImpl(QrCodeRepository qrCodeRepository) {
        super(qrCodeRepository);

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(),
            new ValidatorField("qrContent","O conteúdo do qrCode deve ser informado!"),
            new ValidatorField("hash","O hash do qrCode deve ser informado! "),
            new ValidatorField("expirationDate","A data de expiração do qrCode deve ser informado!")
        ));
    }
    
}