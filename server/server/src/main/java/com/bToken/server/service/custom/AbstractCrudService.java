package com.bToken.server.service.custom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bToken.server.service.validation.ErrorBuilder;
import com.bToken.server.service.validation.ServiceException;

public abstract class AbstractCrudService<T, ID> {
    
    private final JpaRepository<T,ID> repository;

    private final ErrorBuilder errorBuilder = new ErrorBuilder();

    private ValidatorEntity<T> validatorEntity;

    public AbstractCrudService( JpaRepository<T,ID> repository) {
        this.repository = repository;
    }

    public void validate(T entity) throws ServiceException {
        if(validatorEntity != null){
            try {
                if(!validatorEntity.entityIsValid(entity)){
                    throw new ServiceException("Validation failed",errorBuilder.getErrorList());
                }
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    public T getById(ID id) throws ServiceException {
        Optional<T> entitySearchedById = repository.findById(id);

        if(!entitySearchedById.isPresent()){
            throw new ServiceException("No entity found for that id");
        }

        return entitySearchedById.get();
    }

    
    public List<T> listAll() throws ServiceException {
        return repository.findAll();
    }

    public T saveEntity(T entity) throws ServiceException{
        return repository.save(entity);
    }

    public void beforeSave(T entity) throws ServiceException {}

    public void afterSave(T entity) throws ServiceException {}

    public T save(T entity) throws ServiceException {
        beforeSave(entity);
        validate(entity);
        T savedEntity = saveEntity(entity);
        afterSave(entity);

        return savedEntity;
    }

    public T updateEntity(T entity) throws ServiceException {
        return repository.save(entity);
    }

    public void beforeUpdate(T entity) throws ServiceException {}

    public void afterUpdate(T entity) throws ServiceException {}

    public T update(T entity) throws ServiceException {
        beforeUpdate(entity);
        validate(entity);
        T updatedEntity = updateEntity(entity);
        afterUpdate(entity);

        return updatedEntity;
    }

    public void deleteById(ID id) throws ServiceException {
        repository.deleteById(id);
    }
    
    public Long count() throws ServiceException {
        return repository.count();
    }

    public JpaRepository<T, ID> getRepository() {
        return repository;
    }

    public ErrorBuilder getErrorBuilder() {
        return errorBuilder;
    }

    public ValidatorEntity<T> getValidatorEntity() {
        return validatorEntity;
    }

    public void setValidatorEntity(ValidatorEntity<T> validatorEntity) {
        this.validatorEntity = validatorEntity;
    }

}
