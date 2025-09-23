package app.vercel.ingenio_theta.haala.shared.exceptions.core;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ApiException extends RuntimeException {
    private LocalDateTime timestamp;
    private HttpStatus status;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
