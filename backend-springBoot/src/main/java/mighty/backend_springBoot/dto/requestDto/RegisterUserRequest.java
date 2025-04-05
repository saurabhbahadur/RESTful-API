package mighty.backend_springBoot.dto.requestDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import mighty.backend_springBoot.models.Users;

import java.time.LocalDate;

@Data
public class RegisterUserRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    private String username;

    private String name;

    private Users.Gender gender;

    private LocalDate dob;
}
