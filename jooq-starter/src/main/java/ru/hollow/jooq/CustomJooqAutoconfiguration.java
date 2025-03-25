package ru.hollow.jooq;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.Import;
import ru.hollow.jooq.conf.JooqContextConf;

@AutoConfiguration(
        value = "ru.hollow.jooq.conf.JooqAutoconfiguration",
        before = JooqAutoConfiguration.class,
        after = {
                DataSourceAutoConfiguration.class
        }
)
@Import(JooqContextConf.class)
public class CustomJooqAutoconfiguration {
}
