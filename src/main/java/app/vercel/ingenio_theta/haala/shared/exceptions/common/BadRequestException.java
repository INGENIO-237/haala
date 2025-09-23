package app.vercel.ingenio_theta.haala.shared.exceptions.common;

import org.springframework.http.HttpStatus;

import app.vercel.ingenio_theta.haala.shared.exceptions.core.ApiException;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}