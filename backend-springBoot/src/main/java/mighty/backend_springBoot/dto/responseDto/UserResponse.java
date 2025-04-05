package mighty.backend_springBoot.dto.responseDto;

import lombok.Data;
import mighty.backend_springBoot.models.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String email;
    private String username;
    private String name;
    private Users.Gender gender;
    private LocalDate dob;
    private LocalDateTime createdAt;
}
