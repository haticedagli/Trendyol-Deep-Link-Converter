package com.trendyol.deeplinkconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ToURLSearchConverterException extends BaseException {
    public ToURLSearchConverterException() {
        super();
    }
    public ToURLSearchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
    public ToURLSearchConverterException(String message) {
        super(message);
    }
    public ToURLSearchConverterException(Throwable cause) {
        super(cause);
    }
}
