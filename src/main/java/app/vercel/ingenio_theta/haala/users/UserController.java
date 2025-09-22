package app.vercel.ingenio_theta.haala.users;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.vercel.ingenio_theta.haala.shared.ApiResponse;
import app.vercel.ingenio_theta.haala.users.dtos.CreateUserDto;
import app.vercel.ingenio_theta.haala.users.dtos.UserResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody CreateUserDto payload) {
        UserResponse response = service.create(payload);

        return new ApiResponse<>("User account created successfully", response, HttpStatus.CREATED).toResponseEntity();
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> find() {
        List<UserResponse> responses = service.find();

        return new ApiResponse<>("List of users retrieves successfully", responses,
                HttpStatus.OK).toResponseEntity();
    }
}
