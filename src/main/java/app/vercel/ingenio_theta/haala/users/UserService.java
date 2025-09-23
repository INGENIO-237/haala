package app.vercel.ingenio_theta.haala.users;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse create(CreateUserDto payload);

    List<UserResponse> find();

    Optional<User> findByEmail(String email);
}
