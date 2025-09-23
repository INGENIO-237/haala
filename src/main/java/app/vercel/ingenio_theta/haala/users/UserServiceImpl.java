package app.vercel.ingenio_theta.haala.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.vercel.ingenio_theta.haala.shared.exceptions.common.ConflictException;
import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse create(CreateUserDto payload) {
        Optional<User> existingUser = findByEmail(payload.getEmail());

        if (existingUser != null) {
            throw new ConflictException("Email already in use");
        }

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

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
