package app.vercel.ingenio_theta.haala.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.vercel.ingenio_theta.haala.shared.exceptions.common.ConflictException;
import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;

public class UserServiceTest {
        @Mock
        private UserRepository repository;

        @InjectMocks
        private UserService service;

        private final List<User> users = List.of(
                        User.builder().id("some-uuid")
                                        .avatar(null).bio(null)
                                        .firstname("John").lastname("Doe")
                                        .email("john.doe@gmail.com").password("some-password")
                                        .build(),
                        User.builder().id("some-uuid-2")
                                        .avatar(null).bio(null)
                                        .firstname("Doe").lastname("John")
                                        .email("doe.john@gmail.com").password("some-password-2")
                                        .build());
        private final CreateUserDto createUserDto = CreateUserDto.builder()
                        .firstname("INGENIO").lastname("Doe")
                        .password("some-password").email("john.d.kalif@gmail.com")
                        .build();
        private final User createdUser = User.builder().id("some-uuid").firstname(createUserDto.getFirstname())
                        .lastname(createUserDto.getLastname()).email(createUserDto.getEmail())
                        .password("some-hashed-password")
                        .avatar(null).bio(null)
                        .build();
        private final CreateUserDto createUserDtoExistingEmail = CreateUserDto.builder()
                        .firstname("INGENIO").lastname("Doe")
                        .password("some-password").email("john.doe@gmail.com")
                        .build();

        @BeforeEach
        @SuppressWarnings("unused")
        void setUp() {
                MockitoAnnotations.openMocks(this);

                // Define repository behaviour
                when(repository.findAll()).thenReturn(users);
                when(repository.save(UserMapper.toUser(createUserDto))).thenReturn(createdUser);
        }

        @Test
        void testGetUsers() {
                List<UserResponse> result = service.find();

                assertEquals(UserMapper.toUserResponseList(users), result);
        }

        @Test
        void testCreateUser_OK() {
                when(repository.findByEmail(createUserDto.getEmail()))
                                .thenReturn(Optional.empty());

                UserResponse result = service.create(createUserDto);

                assertNotNull(createdUser.getId());
                assertEquals(UserMapper.toUserResponse(createdUser), result);
        }

        @Test
        void testCreateUser_ExistingEmail() {
                when(repository.findByEmail(createUserDtoExistingEmail.getEmail()))
                                .thenReturn(Optional.of(users.stream()
                                                .filter(user -> user.getEmail()
                                                                .equals(createUserDtoExistingEmail.getEmail()))
                                                .toList()
                                                .getFirst()));

                ConflictException ex = assertThrows(ConflictException.class,
                                () -> service.create(createUserDtoExistingEmail));

                assertEquals("Email already in use", ex.getMessage());
        }
}
