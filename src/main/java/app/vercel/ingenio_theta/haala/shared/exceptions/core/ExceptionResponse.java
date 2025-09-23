package app.vercel.ingenio_theta.haala.shared.exceptions.core;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
}