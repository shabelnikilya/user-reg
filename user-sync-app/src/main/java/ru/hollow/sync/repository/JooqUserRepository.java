package ru.hollow.sync.repository;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.hollow.jooq.tables.daos.AppUserDao;

@Repository
public class JooqUserRepository extends AppUserDao {


    @Autowired
    public JooqUserRepository(Configuration configuration) {
        super(configuration);
    }
}
