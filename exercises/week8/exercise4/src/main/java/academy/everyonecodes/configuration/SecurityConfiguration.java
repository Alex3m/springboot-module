package academy.everyonecodes.configuration;

import academy.everyonecodes.domein.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@ConfigurationProperties("shop")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(GET, "/products").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> userDetails = users.stream()
                .map(user -> org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                        .password(passwordEncoder().encode(user.getPassword()))
                        .authorities(user.getAuthorities())
                        .build())
                .collect(toList());
        return new InMemoryUserDetailsManager(userDetails);
    }
}
