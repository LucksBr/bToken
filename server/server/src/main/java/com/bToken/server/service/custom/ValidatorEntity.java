package com.bToken.server.service.custom;

import java.lang.reflect.Field;
import java.util.function.Predicate;

import com.bToken.server.service.validation.ErrorBuilder;

public class ValidatorEntity<T> {

    private final ErrorBuilder errorBuilder;

    private final ValidatorField[] fieldsToValidate;

    public ValidatorEntity(ErrorBuilder errorBuilder, ValidatorField... atributtes) {
        this.errorBuilder = errorBuilder;
        this.fieldsToValidate = atributtes;
    }

    public ErrorBuilder getErrorBuilder() {
        return errorBuilder;
    }

    public Boolean entityIsValid(T object) throws Exception {

        for(ValidatorField validatorField :  fieldsToValidate){
            Field field = object.getClass().getDeclaredField(validatorField.getNameField());
            field.setAccessible(true);
            Object valueField = field.get(object);

            if(!fieldIsValid(valueField,validatorField.getCustomFunctionValidate())){
                String messageError = validatorField.getMessageValidate() != null ? validatorField.getMessageValidate() : getDefaultMessageValidateError(validatorField.getNameField());
                errorBuilder.addError(messageError);
            }
            
        }

        return !errorBuilder.isErrors();
    }

    public Boolean fieldIsValid(Object valueField, Predicate<Object> customFunctionValidate){
        return customFunctionValidate != null ? customFunctionValidate.test(valueField) : validateIfValueFieldIsValid(valueField);
    }

    public boolean validateIfValueFieldIsValid(Object valueField){
        return valueField != null;
    }

    public String getDefaultMessageValidateError(String field){
        return "O campo " + field + " deve ser informado!";
    }
}
