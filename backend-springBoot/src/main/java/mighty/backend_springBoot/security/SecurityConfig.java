package mighty.backend_springBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // csrf disabled for APIs
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // All endpoints accessible
                );
        return http.build();
    }

}
