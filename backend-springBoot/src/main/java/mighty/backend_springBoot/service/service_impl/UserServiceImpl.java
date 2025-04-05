package mighty.backend_springBoot.service.service_impl;

import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.UserResponse;
import mighty.backend_springBoot.models.Users;
import mighty.backend_springBoot.respository.UserRepository;
import mighty.backend_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    @Override
    public UserResponse registerUser(RegisterUserRequest request) {


        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setGender(request.getGender());
        user.setDob(request.getDob());

        Users savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setName(savedUser.getName());
        response.setDob(savedUser.getDob());
        response.setGender(savedUser.getGender());
        response.setCreatedAt(savedUser.getCreatedAt());

        return  response;
    }
}
