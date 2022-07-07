package com.trendyol.deeplinkconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ToURLProductConverterException extends BaseException{
    public ToURLProductConverterException() {
        super();
    }
    public ToURLProductConverterException(String message, Throwable cause) {
        super(message, cause);
    }
    public ToURLProductConverterException(String message) {
        super(message);
    }
    public ToURLProductConverterException(Throwable cause) {
        super(cause);
    }
}
