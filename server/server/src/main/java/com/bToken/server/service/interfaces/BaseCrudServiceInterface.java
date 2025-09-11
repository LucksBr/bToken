package com.bToken.server.service.interfaces;

import java.util.List;

import com.bToken.server.service.validation.ServiceException;

public interface BaseCrudServiceInterface<T,ID> {

    T getById(ID id) throws ServiceException;
    
    List<T> listAll() throws ServiceException;

    T saveEntity(T entity) throws ServiceException;

    void beforeSave(T entity) throws ServiceException;

    void afterSave(T entity) throws ServiceException;

    T save(T entity) throws ServiceException;

    T updateEntity(T entity) throws ServiceException;

    void beforeUpdate(T entity) throws ServiceException;

    void afterUpdate(T entity) throws ServiceException;

    T update(T entity) throws ServiceException;

    void deleteById(ID id) throws ServiceException;
    
    Long count() throws ServiceException;

    void validate(T entity) throws ServiceException;
    
}
