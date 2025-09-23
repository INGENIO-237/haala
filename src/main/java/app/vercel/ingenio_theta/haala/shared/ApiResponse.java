package app.vercel.ingenio_theta.haala.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private String message;
    private Object data;
    private HttpStatus status;

    public static <T> ResponseEntity<ApiResponse> build(
            String message, T data,
            HttpStatus status) {
        ApiResponse response = ApiResponse.builder()
                .message(message).data(data)
                .status(status)
                .build();

        return new ResponseEntity<>(response, status);
    }
}
