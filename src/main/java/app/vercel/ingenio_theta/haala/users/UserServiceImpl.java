package app.vercel.ingenio_theta.haala.users;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse create(CreateUserDto payload) {
        // TODO: Hash password
        User user = UserMapper.toUser(payload);

        User createdUser = repository.save(user);

        return UserMapper.toUserResponse(createdUser);
    }

    @Override
    public List<UserResponse> find() {
        List<User> users = repository.findAll();

        return UserMapper.toUserResponseList(users);
    }
}
