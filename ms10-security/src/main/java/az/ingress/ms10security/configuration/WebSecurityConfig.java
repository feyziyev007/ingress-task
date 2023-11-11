package az.ingress.ms10security.configuration;

import az.ingress.ms10security.filter.JwtAuthFilterConfigurerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthFilterConfigurerAdapter authFilterConfigurerAdapter;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.apply(authFilterConfigurerAdapter);
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/auth/sign-in")
                .permitAll()
                .antMatchers("/hello/public")
                .permitAll()
                .antMatchers("/hello/developer")
                .hasAnyRole("developer")
                .antMatchers("/hello/admin")
                .hasAnyRole("admin", "ceo")
                .antMatchers(HttpMethod.GET, "/hello/books").hasAnyRole("developer", "admin", "ceo")
                .antMatchers(HttpMethod.POST, "/hello/books").hasAnyRole("admin");
        super.configure(http);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("orxan")
//                .password(passwordEncoder.encode("1234"))
//                .roles("admin", "ceo")
//                .and()
//                .withUser("elgun")
//                .password(passwordEncoder.encode("1234"))
//                .roles("developer");
//    }


}
