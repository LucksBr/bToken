package com.bToken.server.model.config;


public abstract class Entity<T> implements EntityInterface<T>{

    @Override
    public abstract T getId();

}