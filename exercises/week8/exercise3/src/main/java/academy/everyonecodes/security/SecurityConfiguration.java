package academy.everyonecodes.security;

import academy.everyonecodes.data.SchoolUser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@ConfigurationProperties("school")
@EnableGlobalMethodSecurity(securedEnabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<SchoolUser> schoolUsers;

    public void setSchoolUsers(List<SchoolUser> schoolUsers) {
        this.schoolUsers = schoolUsers;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(GET, "/").permitAll()
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
        List<UserDetails> users = schoolUsers.stream()
                .map(schoolUser -> User.withUsername(schoolUser.getUsername())
                        .password(encoder.encode(schoolUser.getPassword()))
                        .authorities(schoolUser.getAuthorities())
                        .build())
                .collect(Collectors.toList());
        return new InMemoryUserDetailsManager(users);
    }
}

