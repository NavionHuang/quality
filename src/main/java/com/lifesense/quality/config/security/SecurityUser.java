package com.lifesense.quality.config.security;

import com.lifesense.quality.domain.QaUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by 赵春定 on 2017/8/11.
 */
public class SecurityUser implements UserDetails {
    private QaUser user;
    private Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(QaUser user, Collection<SimpleGrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public QaUser getUser() {
        return user;
    }

    public void setUser(QaUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
