package ru.hollow.jooq.conf;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameCase;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("ru.hollow.jooq.conf.JooqContextConf")
public class JooqContextConf {

    @Bean("ru.hollow.jooq.conf.jooqConfiguration")
    @ConditionalOnMissingBean
    public org.jooq.Configuration jooqConfiguration(DataSource dataSource) {
        return new DefaultConfiguration()
                .set(dataSource)
                .set(SQLDialect.POSTGRES)
                .set(
                        new Settings()
                                .withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED)
                                .withRenderNameCase(RenderNameCase.LOWER_IF_UNQUOTED)
                );
    }

    @Bean("ru.hollow.jooq.conf.dslContext")
    @ConditionalOnMissingBean
    public DSLContext dslContext(org.jooq.Configuration configuration) {
        return DSL.using(configuration);
    }
}
