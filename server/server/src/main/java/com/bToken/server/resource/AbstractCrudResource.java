package com.bToken.server.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bToken.server.service.interfaces.BaseCrudServiceInterface;

public abstract class AbstractCrudResource<T,ID> {
    
    private final BaseCrudServiceInterface<T, ID> mainService;

    public AbstractCrudResource(BaseCrudServiceInterface<T, ID> service) {
        this.mainService = service;
    }

    public BaseCrudServiceInterface<T, ID> getService(){
        return this.mainService;
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return mainService.getById(id);
    }

    @GetMapping("/count")
    public Long getById() {
        return mainService.count();
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return mainService.save(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        return mainService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id){
        mainService.deleteById(id);
    }
}
