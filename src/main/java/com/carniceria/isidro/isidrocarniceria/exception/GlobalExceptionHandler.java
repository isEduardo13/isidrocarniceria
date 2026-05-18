package com.carniceria.isidro.isidrocarniceria.exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.carniceria.isidro.isidrocarniceria.exception.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNoSuchElementException(ResourceNotFoundException e, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                404,
                "Not Found",
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The request is invalid, check the request body");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Constraint violation: " + e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Request method not supported");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing request parameter: " + e.getParameterName());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Validation error: " + e.getBindingResult().toString());
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleServletRequestBindingException(ServletRequestBindingException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request binding error: " + e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No handler found for your request");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + e.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.CONTENT_TOO_LARGE)
    public ResponseEntity<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        return ResponseEntity.status(HttpStatus.CONTENT_TOO_LARGE).body("The uploaded file is too large");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseEntity<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Media type not supported");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Malformed JSON request");
    }

}
