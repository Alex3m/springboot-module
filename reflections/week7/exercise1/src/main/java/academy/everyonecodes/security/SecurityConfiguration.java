package academy.everyonecodes.security;

import academy.everyonecodes.data.AccountancyUser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@ConfigurationProperties("accountancy")
@EnableGlobalMethodSecurity(securedEnabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<AccountancyUser> users;

    public void setUsers(List<AccountancyUser> users) {
        this.users = users;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(POST, "/patients").permitAll()
                .anyRequest().hasAuthority("ROLE_ACCOUNTANT")
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(users.stream()
                .map(accountancyUser -> User.withUsername(accountancyUser.getUsername())
                        .password(encoder.encode(accountancyUser.getPassword()))
                        .authorities(accountancyUser.getAuthorities())
                        .build())
                .collect(toList()));
    }
}