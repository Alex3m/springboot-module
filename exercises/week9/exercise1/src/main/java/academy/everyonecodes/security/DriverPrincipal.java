package academy.everyonecodes.security;


import academy.everyonecodes.domain.Driver;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class DriverPrincipal implements UserDetails {
    private final Driver driver;

    public DriverPrincipal(Driver driver) {
        this.driver = driver;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> authorities = driver.getAuthorities();
        return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
    }


    @Override
    public String getPassword() {
        return driver.getPassword();
    }

    @Override
    public String getUsername() {
        return driver.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
