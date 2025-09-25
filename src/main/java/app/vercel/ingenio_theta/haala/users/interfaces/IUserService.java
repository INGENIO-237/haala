package app.vercel.ingenio_theta.haala.users.interfaces;

import app.vercel.ingenio_theta.haala.users.User;
import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserResponse create(CreateUserDto payload);

    List<UserResponse> find();

    Optional<User> findByEmail(String email);
}
