package app.vercel.ingenio_theta.haala.users;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

import java.util.List;

public class UserMapper {
    public static User toUser(CreateUserDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .password(dto.getPassword())
                .build();
    }

    public static UserResponse toUserResponse (User user) {
        return UserResponse.builder()
                .id(user.getId())
                .bio(user.getBio())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }

    public static List<UserResponse> toUserResponseList (List<User> users) {
        return users.stream()
                .map(UserMapper::toUserResponse)
                .toList();
    }
}
