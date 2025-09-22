package app.vercel.ingenio_theta.haala.shared;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;
    private HttpStatus status;

    public ApiResponse(String message, T data, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public ResponseEntity<Map<String, Object>> toResponseEntity() {
        Map<String, Object> response = new HashMap<>();

        response.put("status", status);
        response.put("message", message);
        response.put("data", data);

        return new ResponseEntity<>(response, status);
    }
}
