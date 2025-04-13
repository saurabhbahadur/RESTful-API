package mighty.backend_springBoot.dto.responseDto;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class LoginUserResponse {

    private UUID Id;
    private String username;
    private String email;
    private String token;
}
