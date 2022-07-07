package com.trendyol.deeplinkconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ToDeeplinkSearchConverterException extends BaseException{
    public ToDeeplinkSearchConverterException() {
        super();
    }
    public ToDeeplinkSearchConverterException(String message, Throwable cause) {
        super(message, cause);
    }
    public ToDeeplinkSearchConverterException(String message) {
        super(message);
    }
    public ToDeeplinkSearchConverterException(Throwable cause) {
        super(cause);
    }
}
