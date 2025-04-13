package mighty.backend_springBoot.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponse {

    private String title;
    private String message;
    private String username;
    private LocalDateTime createdAt;


}
