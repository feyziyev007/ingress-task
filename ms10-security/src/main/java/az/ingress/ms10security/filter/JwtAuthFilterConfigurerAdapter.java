package az.ingress.ms10security.filter;

import az.ingress.ms10security.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilterConfigurerAdapter extends
        SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtAuthRequestFilter jwtAuthRequestFilter;
    private final List<AuthService> authServices;

    @Override
    public void configure(HttpSecurity http) {
        log.trace("Added auth request filter");
        http.addFilterBefore(jwtAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
