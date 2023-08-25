package org.security.service;

import org.security.model.CustomUserDetails;
import org.security.model.User;
import org.security.repository.UserNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Custom userDetailsService implementation which is invoked by
 * DAOAuthentication Provider
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserNameRepository repository;

    @Autowired
    public void setRepository(UserNameRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }
}
