package org.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 *  CustomUserDetail class used in CustomUserDetailsService to return
 *  UserDetails instance
 */
public class CustomUserDetails implements UserDetails {
    private User user;

    public CustomUserDetails(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Authorities authorities = user.getAuthorities();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authorities.getAuthority());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
