package mighty.backend_springBoot.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mighty.backend_springBoot.dto.requestDto.LoginUserRequest;
import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.LoginUserResponse;
import mighty.backend_springBoot.dto.responseDto.RegisterUserResponse;
import mighty.backend_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        log.info("Register endpoint called of User Controller ");
        RegisterUserResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(@Valid @RequestBody LoginUserRequest loginUserRequest){
        log.info("Login endpoint called of User Controller ");
        return ResponseEntity.ok(userService.loginUser(loginUserRequest));
    }

}
