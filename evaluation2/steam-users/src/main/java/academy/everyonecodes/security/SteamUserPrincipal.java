package academy.everyonecodes.security;

import academy.everyonecodes.domain.SteamUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SteamUserPrincipal implements UserDetails {
    private final SteamUser steamUser;

    public SteamUserPrincipal(SteamUser steamUser) {
        this.steamUser = steamUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authorities = steamUser.getAuthorities();
        return AuthorityUtils.createAuthorityList(authorities);
    }

    @Override
    public String getPassword() {
        return steamUser.getPassword();
    }

    @Override
    public String getUsername() {
        return steamUser.getUsername();
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
