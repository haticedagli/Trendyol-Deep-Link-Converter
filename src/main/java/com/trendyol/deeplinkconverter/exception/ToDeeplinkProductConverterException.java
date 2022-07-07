package com.trendyol.deeplinkconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ToDeeplinkProductConverterException extends BaseException {
    public ToDeeplinkProductConverterException() {
        super();
    }
    public ToDeeplinkProductConverterException(String message, Throwable cause) {
        super(message, cause);
    }
    public ToDeeplinkProductConverterException(String message) {
        super(message);
    }
    public ToDeeplinkProductConverterException(Throwable cause) {
        super(cause);
    }
}
