package com.premiumshopcarbackend.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{

    private List<FieldMessage> listError = new ArrayList<>();

    public ValidationError(String msg, Integer statusHttp, Long timeStamp) {
        super(msg, statusHttp, timeStamp);
    }

    public List<FieldMessage> getListError() {
        return listError;
    }

    public void setListError(String fieldName, String message) {
        listError.add(new FieldMessage(fieldName, message));
    }
}
