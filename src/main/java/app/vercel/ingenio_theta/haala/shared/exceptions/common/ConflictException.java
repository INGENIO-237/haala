package app.vercel.ingenio_theta.haala.shared.exceptions.common;

import org.springframework.http.HttpStatus;

import app.vercel.ingenio_theta.haala.shared.exceptions.core.ApiException;

public class ConflictException extends ApiException {
    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
