package app.vercel.ingenio_theta.haala.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    private final CreateUserDto createUserDto = CreateUserDto.builder().email("john.doe@gmail.com")
            .password("some-dummy-password").firstname("John").lastname("Doe").build();

    @Test
    void testFindByEmail_Found() {
        User user = UserMapper.toUser(createUserDto);

        repository.save(user);

        Optional<User> result = repository.findByEmail(createUserDto.getEmail());

        assertEquals(false, result.isEmpty());
        assertEquals(createUserDto.getEmail(), result.get().getEmail());
    }

    @Test
    void testFindByEmail_NotFound() {
        Optional<User> result = repository.findByEmail("not.existing@gmail.com");

        assertEquals(true, result.isEmpty());
        assertEquals(false, result.isPresent());
    }
}