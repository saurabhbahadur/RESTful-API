package mighty.backend_springBoot.service;

import mighty.backend_springBoot.dto.requestDto.RegisterUserRequest;
import mighty.backend_springBoot.dto.responseDto.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest request);
}
