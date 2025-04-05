package mighty.backend_springBoot.controller;


import jakarta.validation.Valid;
import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.UserResponse;
import mighty.backend_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid RegisterUserRequest request){
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
