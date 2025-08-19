package com.bToken.server.service.custom;

import java.util.function.Predicate;

public class ValidatorField {

    private String nameField;

    private String messageValidate;

    private Predicate<Object> customFunctionValidate;

    public ValidatorField(String nameField) {
        this.nameField = nameField;
    }

    public ValidatorField(String nameField, String messageValidate) {
        this.nameField = nameField;
        this.messageValidate = messageValidate;
    }

    public ValidatorField(String nameField, String messageValidate, Predicate<Object> customFunctionValidate) {
        this.nameField = nameField;
        this.messageValidate = messageValidate;
        this.customFunctionValidate = customFunctionValidate;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getMessageValidate() {
        return messageValidate;
    }

    public void setMessageValidate(String messageValidate) {
        this.messageValidate = messageValidate;
    }

    public Predicate<Object> getCustomFunctionValidate() {
        return customFunctionValidate;
    }

    public void setCustomFunctionValidate(Predicate<Object> customFunctionValidate) {
        this.customFunctionValidate = customFunctionValidate;
    }

    public Boolean validate(Object object){
        return customFunctionValidate.test(object);
    }

}
