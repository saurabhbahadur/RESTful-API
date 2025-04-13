package mighty.backend_springBoot.dto.responseDto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserResponse {

    private String username;
    private String email;
    private String token;
}
