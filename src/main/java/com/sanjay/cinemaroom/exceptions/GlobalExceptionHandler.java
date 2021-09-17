package com.sanjay.cinemaroom.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception, WebRequest request) {
        ExceptionBody exceptionBody = new ExceptionBody(exception.getMessage());
        return new ResponseEntity<>(exceptionBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(UnauthorizedException exception, WebRequest request) {
        ExceptionBody exceptionBody  = new ExceptionBody(exception.getMessage());
        return new ResponseEntity<>(exceptionBody, HttpStatus.UNAUTHORIZED);
    }

}
