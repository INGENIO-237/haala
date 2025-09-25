package app.vercel.ingenio_theta.haala.users;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

public class UserMapperTest {
    private final CreateUserDto createUserDto = CreateUserDto.builder()
            .firstname("INGENIO").lastname("Doe")
            .password("some-password").email("john.d.kalif@gmail.com")
            .build();

    private final User createdUser = User.builder().id("some-uuid").firstname(createUserDto.getFirstname())
            .lastname(createUserDto.getLastname()).email(createUserDto.getEmail())
            .password("some-hashed-password")
            .avatar(null).bio(null)
            .build();

    @Test
    void testToUser() {

        User user = UserMapper.toUser(createUserDto);

        assertEquals(createUserDto.getFirstname(), user.getFirstname());
        assertEquals(createUserDto.getLastname(), user.getLastname());
        assertEquals(createUserDto.getEmail(), user.getEmail());
        assertEquals(createUserDto.getPassword(), user.getPassword());
    }

    @Test
    void testToUserResponse() {
        UserResponse userResponse = UserMapper.toUserResponse(createdUser);

        assertEquals(createdUser.getId(), userResponse.getId());
        assertEquals(createdUser.getFirstname(), userResponse.getFirstname());
        assertEquals(createdUser.getLastname(), userResponse.getLastname());
        assertEquals(createdUser.getEmail(), userResponse.getEmail());
        assertEquals(createdUser.getAvatar(), userResponse.getAvatar());
        assertEquals(createdUser.getBio(), userResponse.getBio());
    }

    @Test
    void testToUserResponseList() {
        var users = UserMapper.toUserResponseList(List.of(createdUser, createdUser));

        assertEquals(2, users.size());
        for (UserResponse userResponse : users) {
            assertEquals(createdUser.getId(), userResponse.getId());
            assertEquals(createdUser.getFirstname(), userResponse.getFirstname());
            assertEquals(createdUser.getLastname(), userResponse.getLastname());
            assertEquals(createdUser.getEmail(), userResponse.getEmail());
            assertEquals(createdUser.getAvatar(), userResponse.getAvatar());
            assertEquals(createdUser.getBio(), userResponse.getBio());
        }
    }
}
