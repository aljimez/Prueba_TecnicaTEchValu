package com.booksproyects.books.book.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.validation.FieldError;


public class GlobalExceptionHandler{

    //controla los errores de los campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlderMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          WebRequest webRequest) {
        Map<String, String> mapErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
                    String clave = ((FieldError) error).getField();
                    String valor = error.getDefaultMessage();
                    mapErrors.put(clave, valor);
                }
        );
        ExceptionDetails exceptionDetails = new ExceptionDetails(mapErrors.toString(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    //controla los errores not found 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails("Not found Error: "+exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
    //Controla los errores al no encontrar algunos de los datos que se buscan
  @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionDetails> NoResourceFoundException(ResourceNotFoundException exception,
            WebRequest webRequest) {
ExceptionDetails exceptionDetails = new ExceptionDetails("Not Found Error: "+exception.getMessage(), webRequest.getDescription(false));
return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
}

    //controla los errores globales de los path en 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNoHandlerFoundException(NoHandlerFoundException  exception,
                                                                        WebRequest webRequest) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails("Not Found Error "+exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    //controla los errores de logica o de los catch en general 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(BadRequestException exception,
                                                                        WebRequest webRequest) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails("Bad Request Error "+exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    //controla los errores de varios tipos y globalizrlo con un error 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handlerException(Exception exception,
                                                                  WebRequest webRequest) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails("Internal Server Error "+exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //Controla los errores relacionados con el tipo de datos introducidos
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Tipo de contenido no soportado: " + e.getContentType());
    }
    //Controla los errores de entrada y salida de datos
 @ExceptionHandler(IOException.class)
 public ResponseEntity<Object> handleIOException (IOException e){
     return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Problema en operación de entrada y salida");
 }
}
