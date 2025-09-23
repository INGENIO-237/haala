package app.vercel.ingenio_theta.haala.shared;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import app.vercel.ingenio_theta.haala.shared.exceptions.common.BadRequestException;
import app.vercel.ingenio_theta.haala.shared.exceptions.common.ConflictException;
import app.vercel.ingenio_theta.haala.shared.exceptions.core.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        ExceptionResponse response = ExceptionResponse.builder().message("Validation failed")
                .status(HttpStatus.BAD_REQUEST).errors(errors).build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex) {
        ExceptionResponse response = ExceptionResponse.builder().message(ex.getMessage()).status(ex.getStatus())
                .timestamp(ex.getTimestamp()).build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionResponse> handleConflictException(ConflictException ex) {
        ExceptionResponse response = ExceptionResponse.builder().message(ex.getMessage()).status(ex.getStatus())
                .timestamp(ex.getTimestamp()).build();

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}