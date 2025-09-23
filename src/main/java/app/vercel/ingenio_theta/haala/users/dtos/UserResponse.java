package app.vercel.ingenio_theta.haala.users.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String bio;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
