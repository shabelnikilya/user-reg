package ru.hollow.sync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hollow.jooq.tables.pojos.AppUser;
import ru.hollow.security.core.service.SecurityUserDetailsService;
import ru.hollow.sync.repository.JooqUserRepository;

@Service
public class UserServiceImpl implements SecurityUserDetailsService<AppUser> {

    private final JooqUserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(JooqUserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    public AppUser save(AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.insert(user);
        return user;
    }

    @Override
    public AppUser getByUsername(String username) {
        return repository.fetchOneByUsername(username);
    }
}
