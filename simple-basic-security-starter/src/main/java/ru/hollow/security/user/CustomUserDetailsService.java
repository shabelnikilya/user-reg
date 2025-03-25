package ru.hollow.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.hollow.jooq.tables.pojos.AppUser;
import ru.hollow.security.core.service.SecurityUserDetailsService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final String DEFAULT_ROLE = "USER";

    private final SecurityUserDetailsService<AppUser> service;

    @Autowired
    public CustomUserDetailsService(SecurityUserDetailsService<AppUser> service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var appUser = service.getByUsername(username);
        return User
                .builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(DEFAULT_ROLE)
                .build();
    }
}
