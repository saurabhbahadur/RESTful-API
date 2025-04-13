package mighty.backend_springBoot.service.service_impl;

import lombok.extern.slf4j.Slf4j;
import mighty.backend_springBoot.dto.requestDto.LoginUserRequest;
import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.LoginUserResponse;
import mighty.backend_springBoot.dto.responseDto.RegisterUserResponse;
import mighty.backend_springBoot.exceptions.InvalidCredentialsException;
import mighty.backend_springBoot.models.Users;
import mighty.backend_springBoot.respository.UserRepository;
import mighty.backend_springBoot.security.JwtUtil;
import mighty.backend_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;



    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {

        log.info("Register User Service Impl called ..... ");

        // Check if email or username already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }

        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setGender(request.getGender());
        user.setDob(request.getDob());

        Users savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();

        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setName(savedUser.getName());
        response.setDob(savedUser.getDob());
        response.setGender(savedUser.getGender());
        response.setCreatedAt(savedUser.getCreatedAt());

        return  response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {

        log.info("Login User Service Impl called ..... ");

        Users user = userRepository.findByEmail(loginUserRequest.getEmail())
                .orElseThrow(()-> new InvalidCredentialsException("Invalid email or password"));

        if(!passwordEncoder.matches(loginUserRequest.getPassword(), user.getPassword())) {
        throw new InvalidCredentialsException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return LoginUserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .token(token)
                .build();
    }
}
