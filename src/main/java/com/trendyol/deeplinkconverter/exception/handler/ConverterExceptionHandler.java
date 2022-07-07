package com.trendyol.deeplinkconverter.exception.handler;

import com.trendyol.deeplinkconverter.exception.ToDeeplinkProductConverterException;
import com.trendyol.deeplinkconverter.exception.ToDeeplinkSearchConverterException;
import com.trendyol.deeplinkconverter.exception.ToURLProductConverterException;
import com.trendyol.deeplinkconverter.exception.ToURLSearchConverterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ConverterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ToDeeplinkProductConverterException.class })
    public ResponseEntity<Object> handleToDeeplinkProductException(ToDeeplinkProductConverterException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Ops! Something went wrong while converting product url to deeplink.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ ToDeeplinkSearchConverterException.class })
    public ResponseEntity<Object> handleToDeeplinkSearchException(ToDeeplinkSearchConverterException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Ops! Something went wrong while converting search url to deeplink.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ ToURLProductConverterException.class })
    public ResponseEntity<Object> handleToURLProductException(ToURLProductConverterException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Ops! Something went wrong while converting product deeplink to url.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ ToURLSearchConverterException.class })
    public ResponseEntity<Object> handleToURLSearchException(ToURLSearchConverterException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Ops! Something went wrong while converting search deeplink to url.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
