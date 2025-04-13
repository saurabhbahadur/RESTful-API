package mighty.backend_springBoot.security;

import lombok.extern.slf4j.Slf4j;
import mighty.backend_springBoot.models.Users;
import mighty.backend_springBoot.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        log.info("CustomeUserDetailService called by email " +email);

        Users user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User Not Found with email" + email));


        return new User(user.getEmail(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
