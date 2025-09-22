package app.vercel.ingenio_theta.haala.users;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(CreateUserDto payload);
    List<UserResponse> find();
}
