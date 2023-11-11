package az.ingress.ms10security;

import az.ingress.ms10security.domain.Authority;
import az.ingress.ms10security.domain.User;
import az.ingress.ms10security.repository.AuthorityRepository;
import az.ingress.ms10security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class Ms10SecurityApplication implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ms10SecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
      //  user.setId(1L);
        user.setUsername("orxan");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        Authority authority = new Authority();
       // authority.setId(1L);
        authority.setAuthority("ROLE_ceo");

        Authority authority1 = new Authority();
      //  authority1.setId(2L);
        authority1.setAuthority("ROLE_admin");
        user.setAuthorities(List.of(authority1, authority));
       // authorityRepository.save(authority);
       // authorityRepository.save(authority1);
       // userRepository.save(user);

        System.out.println("{noop}1234");
        System.out.println(passwordEncoder.encode("1234"));
    }
}
