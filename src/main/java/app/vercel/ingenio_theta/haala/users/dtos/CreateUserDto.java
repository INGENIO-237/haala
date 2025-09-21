package app.vercel.ingenio_theta.haala.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
