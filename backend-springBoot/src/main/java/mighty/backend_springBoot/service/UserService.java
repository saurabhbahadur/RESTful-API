package mighty.backend_springBoot.service;

import mighty.backend_springBoot.dto.requestDto.LoginUserRequest;
import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.LoginUserResponse;
import mighty.backend_springBoot.dto.responseDto.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);
}
