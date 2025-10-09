package com.bToken.server.service.config;

import com.bToken.server.model.ImageFile;
import com.bToken.server.repository.interfaces.ImageFileRepository;
import com.bToken.server.service.custom.AbstractCrudService;
import com.bToken.server.service.custom.ValidatorEntity;
import com.bToken.server.service.custom.ValidatorField;

public class ImageFileServiceImpl extends AbstractCrudService<ImageFile, Integer> {

    public ImageFileServiceImpl(ImageFileRepository imageFileRepository) {
        super(imageFileRepository);

        setValidatorEntity(new ValidatorEntity<>(getErrorBuilder(), 
            new ValidatorField("url","A url da imagem deve ser informada!"),
            new ValidatorField("mimeType","O mimeType da imagem deve ser informado!"),
            new ValidatorField("size","O tamanho da imagem deve ser informado!"),
            new ValidatorField("imageStorageTypeEnum","O tipo de armazenamento da imagem deve ser informado!")
        ));
    }
    
}
