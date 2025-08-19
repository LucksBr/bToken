package com.bToken.server.service.validation;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends RuntimeException {

    private final List<String> errorsMessage;

    public ServiceException(String message) {
        super("Service error");
        this.errorsMessage = new ArrayList<>();
        this.errorsMessage.add(message);
    }

    public ServiceException(List<String> errorsMessage) {
        super("Service errors");
        this.errorsMessage = errorsMessage;
    }

    public ServiceException(String mainMessage, List<String> errorsMessage) {
        super(mainMessage);
        this.errorsMessage = errorsMessage;
    }

    public ServiceException(String mainMessage, ErrorBuilder errorBuilder) {
        super(mainMessage);
        this.errorsMessage = errorBuilder.getErrorList();
    }

    public List<String> getErrorsMessage() {
        return errorsMessage;
    }

}
