package com.bToken.server.service.validation;

import java.util.ArrayList;
import java.util.List;

public class ErrorBuilder {

    private final List<String> errors;

    public ErrorBuilder(){
        this.errors = new ArrayList<>();
    }

    public void addError(String error){
        errors.add(error);
    }

    public void addErrors(List<String> errors){
        errors.addAll(errors);
    }

    public Boolean isErrors(){
        return !errors.isEmpty();
    }

    public List<String> getErrorList(){
        return errors;
    }
    
}
